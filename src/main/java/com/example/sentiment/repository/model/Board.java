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
public class Board {

    private int postId;
    private String title;
    private String content;
    private String author;
    private Timestamp createdAt;

}
