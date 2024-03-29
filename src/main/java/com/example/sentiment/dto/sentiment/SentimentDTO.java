package com.example.sentiment.dto.sentiment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SentimentDTO {

    private int sentimentId;
    private int boardId;
    private String content;
    private String createdAt;

}
