package com.example.sentiment.sevice.sentiment;

import com.example.sentiment.crud.interfaces.Converter;
import com.example.sentiment.dto.sentiment.SentimentDTO;
import com.example.sentiment.repository.model.Sentiment;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Service
public class SentimentConverter implements Converter<SentimentDTO, Sentiment> {


    @Override
    public SentimentDTO toDto(Sentiment sentiment) {
        Timestamp createdAt = sentiment.getCreatedAt();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String formatCreatedAt = sdf.format(createdAt);


        return SentimentDTO.builder()
                .sentimentId(sentiment.getSentimentId())
                .boardId(sentiment.getBoardId())
                .content(sentiment.getContent())
                .createdAt(formatCreatedAt)
                .build();
    }

    @Override
    public Sentiment toEntity(SentimentDTO sentimentDTO) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        return Sentiment.builder()
                .sentimentId(sentimentDTO.getSentimentId())
                .boardId(sentimentDTO.getBoardId())
                .content(sentimentDTO.getContent())
                .createdAt(timestamp)
                .build();
    }
}
