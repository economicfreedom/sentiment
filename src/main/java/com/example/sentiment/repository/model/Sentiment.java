package com.example.sentiment.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sentiment {

    private int sentimentId;
    private int boardId;
    private String content;
    private Timestamp createdAt;

}
