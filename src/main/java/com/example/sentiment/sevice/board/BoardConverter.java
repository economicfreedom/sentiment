package com.example.sentiment.sevice.board;


import com.example.sentiment.crud.interfaces.Converter;
import com.example.sentiment.dto.board.BoardDTO;
import com.example.sentiment.repository.model.Board;
import org.springframework.stereotype.Service;

@Service
public class BoardConverter implements Converter<BoardDTO,Board> {
    @Override
    public BoardDTO toDto(Board board) {
        return null;
    }

    @Override
    public Board toEntity(BoardDTO boardDTO) {
        return null;
    }

}
