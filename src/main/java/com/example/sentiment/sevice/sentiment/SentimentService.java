package com.example.sentiment.sevice.sentiment;

import com.example.sentiment.crud.abs.CRUDAbstractService;
import com.example.sentiment.crud.interfaces.CRUDRepositoryInterface;
import com.example.sentiment.crud.interfaces.Converter;
import com.example.sentiment.dto.gpt.GPTRequest;
import com.example.sentiment.dto.gpt.GPTResponse;
import com.example.sentiment.dto.sentiment.SentimentDTO;
import com.example.sentiment.repository.interfaces.CommentRepository;
import com.example.sentiment.repository.interfaces.SentimentRepository;
import com.example.sentiment.repository.model.Sentiment;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class SentimentService extends CRUDAbstractService<SentimentDTO, Sentiment> {
    @Value("${gpt.model}")
    private String model;
    @Value("${gpt.api.url}")
    private String apiURL;
    private final RestTemplate template;

    private final CommentRepository commentRepository;
    private final SentimentRepository sentimentRepository;

    private final Converter<SentimentDTO, Sentiment> converter;

    private static final String KOREAN_PATTERN = "[^가-힣\\s]";
    private static final String BRACKETED_TEXT_PATTERN = "\\((.*?)\\)";
    private static final String PROMPT_1 = "저는 형태소 분석된 단어들을 대괄호안에 입력하였습니다.\n"
            + "이 단어들은 게시판에 달린 댓글들을 형태소 분석한 단어들이며\n"
            + "이 단어들을 보고 총평을 해주십시오. 총평을 해줄 때 저의 요구사항은 다음과 같습니다.\n"
            + "1. 저의 말을 따라하지 말아주십시오\n"
            + "2.총평은 반드시 소괄호로 묶어주십시오.\n"
            + "3.저는 당신에게 총평 이외에 답변은 원하지 않습니다.\n"
            + "4.형태소 분석된 단어들은 대괄호 안에 있습니다.\n"
            + "5.저는 단어 각각의 평가를 원하는 것이 아닌 단어들 전체의 평가를 원합니다.\n"
            + "6.저의 예시를 지켜가며 소괄호에 반드시 총평을 넣어주십시오.\n"
            + "7.만약 부각되거나 특출난 장점이나 단점이 있다면 창의성을 발휘하여 예시에 추가해주십시오.\n"
            + "8.답변에 사용되는 소괄호는 하나만 사용해주세요\n"
            + "아래는 총평된 데이터들 입니다\n[";

    private static final String PROMPT_2 = "]\n대괄호에 있는 단어들을 보고 총평을 해주십시오 아래는 예시입니다.\n"
            + "(대체적으로 긍정적이며 좋다는 표현들이 많습니다 해당 게시글은 좋은 게시글인거 같습니다.)";


    @Autowired
    public SentimentService(CRUDRepositoryInterface<Sentiment> repository,
                            Converter<SentimentDTO, Sentiment> converter,
                            CommentRepository commentRepository,
                            RestTemplate restTemplate,
                            SentimentRepository sentimentRepository) {
        super(repository, converter);
        this.converter = converter;
        this.commentRepository = commentRepository;
        this.sentimentRepository = sentimentRepository;
        this.template = restTemplate;

    }

    public SentimentDTO findByBoardId(int boardId) {

        Sentiment entity = sentimentRepository.findByBoardId(boardId);

        return converter.toDto(entity);

    }

    @Override
    public int create(SentimentDTO sentimentDTO) {
        String concat = getConcatCommentContent(sentimentDTO.getBoardId());
        String morph = getMorph(concat);
        log.info(morph);
        String res = gptRequest(morph);

        sentimentDTO.setContent(res);


        return super.create(sentimentDTO);
    }

    private String getConcatCommentContent(int boardId) {
        List<String> contents = commentRepository.findContentListByBoardId(boardId);
        StringBuilder stringBuilder = new StringBuilder();


        for (String content : contents) {

            stringBuilder.append(content);

        }


        return stringBuilder.toString();
    }

    private String getMorph(String concat) {
        Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);

        //한국어 가~핳 까지만 사용
        KomoranResult analyze = komoran.analyze(concat
                .replaceAll(KOREAN_PATTERN, ""));
        log.info(analyze.getPlainText());
        List<Token> tokenList = analyze.getTokenList();

        StringBuilder res = new StringBuilder();
        for (Token token : tokenList) {

            if (token.getPos().equals("NNG") ||
                    token.getPos().equals("VA") ||
                    token.getPos().equals("VV") ||
                    token.getPos().equals("MAG")

            ) {
                //형태소 분석엔 주로
                //일반명사(NNG),형용사(VA),동사(VV),부사(MAG)가 필요함
                res.append(token.getMorph()).append(",");
            }


        }

        return res.toString();
    }

    private String gptRequest(String morph) {


        String prompt = PROMPT_1 + morph + PROMPT_2;
        System.out.println(morph.toString());
        GPTRequest request = new GPTRequest(model, prompt);

        GPTResponse chatGptResponse = template.postForObject(apiURL, request, GPTResponse.class);

        String content = chatGptResponse.getChoices().get(0).getMessage().getContent();
        content = find(content);

        return content;
    }

    private String find(String content) {
        Matcher matcher = Pattern.compile(BRACKETED_TEXT_PATTERN).matcher(content);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return "";
    }
}
