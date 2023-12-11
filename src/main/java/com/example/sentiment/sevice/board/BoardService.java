package com.example.sentiment.sevice.board;

import com.example.sentiment.crud.abs.CRUDAbstractService;
import com.example.sentiment.crud.interfaces.Converter;
import com.example.sentiment.dto.board.BoardDTO;
import com.example.sentiment.repository.interfaces.BoardRepository;
import com.example.sentiment.repository.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class BoardService extends CRUDAbstractService<BoardDTO, Board> {

    private BoardRepository boardRepository ;
    private Converter<BoardDTO,Board> converter;

    public BoardService(BoardRepository boardRepository, Converter<BoardDTO,Board> converter) {
        super(boardRepository,converter);

    }

}
