package com.example.sentiment.controller.board;


import com.example.sentiment.crud.abs.CRUDAbstractApiController;
import com.example.sentiment.dto.board.BoardDTO;
import com.example.sentiment.repository.model.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-board")
@Slf4j
@RequiredArgsConstructor

public class BoardAPIController extends CRUDAbstractApiController<BoardDTO, Board> {






}
