package com.example.sentiment.sevice.board;

import com.example.sentiment.crud.abs.CRUDAbstractService;
import com.example.sentiment.dto.board.BoardDTO;
import com.example.sentiment.repository.interfaces.BoardRepository;
import com.example.sentiment.repository.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class BoardService extends CRUDAbstractService<BoardDTO, Board> {


    @Autowired
    public BoardService(BoardRepository boardRepository) {
        super(boardRepository);
    }

}
