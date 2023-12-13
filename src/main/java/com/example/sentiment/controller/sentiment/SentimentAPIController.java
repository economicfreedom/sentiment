package com.example.sentiment.controller.sentiment;

import com.example.sentiment.crud.abs.CRUDAbstractApiController;
import com.example.sentiment.dto.sentiment.SentimentDTO;
import com.example.sentiment.repository.model.Sentiment;
import com.example.sentiment.sevice.sentiment.SentimentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-sentiment")
@Slf4j
public class SentimentAPIController extends CRUDAbstractApiController<SentimentDTO, Sentiment> {

    private final SentimentService sentimentService;

    @Autowired
    public SentimentAPIController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @GetMapping("/get-sentiment/{boardId}")
    public ResponseEntity<?> findSentimentById(@PathVariable int boardId){

        SentimentDTO dto = sentimentService.findByBoardId(boardId);
        if (dto == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(dto);

    }

}
