package com.example.sentiment.controller.board;


import com.example.sentiment.crud.abs.CRUDAbstractController;
import com.example.sentiment.dto.board.BoardDTO;
import com.example.sentiment.repository.model.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController extends CRUDAbstractController<BoardDTO, Board> {

    @Override
    protected String getBasePath() {
        return "board";
    }
}
