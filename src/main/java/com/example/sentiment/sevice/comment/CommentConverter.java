package com.example.sentiment.sevice.comment;

import com.example.sentiment.crud.interfaces.Converter;
import com.example.sentiment.dto.comment.CommentDTO;
import com.example.sentiment.repository.model.Comment;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Service
public class CommentConverter implements Converter<CommentDTO, Comment> {

    @Override
    public CommentDTO toDto(Comment comment) {
        Timestamp createdAt = comment.getCreatedAt();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String formatCreatedAt = sdf.format(createdAt);


        return CommentDTO.builder()
                .commentId(comment.getCommentId())
                .boardId(comment.getBoardId())
                .content(comment.getContent())
                .createdAt(formatCreatedAt)
                .build();
    }

    @Override
    public Comment toEntity(CommentDTO commentDTO) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        return Comment.builder()
                .commentId(commentDTO.getCommentId())
                .boardId(commentDTO.getBoardId())
                .content(commentDTO.getContent())
                .createdAt(timestamp)
                .build();
    }
}
