package com.example.sentiment.sevice.board;


import com.example.sentiment.crud.interfaces.Converter;
import com.example.sentiment.dto.board.BoardDTO;
import com.example.sentiment.repository.model.Board;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Service
public class BoardConverter implements Converter<BoardDTO, Board> {
    @Override
    public BoardDTO toDto(Board board) {
        Timestamp createdAt = board.getCreatedAt();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String formatCreatedAt = sdf.format(createdAt);



        return BoardDTO.builder()
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .content(board.getContent())
                .author(board.getAuthor())
                .createdAt(formatCreatedAt)
                .build();
    }

    @Override
    public Board toEntity(BoardDTO boardDTO) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        return Board.builder()
                .boardId(boardDTO.getBoardId())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .author(boardDTO.getAuthor())
                .createdAt(timestamp)
                .build();
    }

}
