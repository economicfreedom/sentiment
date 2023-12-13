package com.example.sentiment.controller.comment;


import com.example.sentiment.crud.abs.CRUDAbstractApiController;
import com.example.sentiment.dto.comment.CommentDTO;
import com.example.sentiment.repository.interfaces.BoardRepository;
import com.example.sentiment.repository.model.Comment;
import com.example.sentiment.sevice.comment.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-comment")
@Slf4j
public class CommentAPIController extends CRUDAbstractApiController<CommentDTO, Comment> {


    private final CommentService commentService;

    @Autowired
    public CommentAPIController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/get-list-by-id/{id}")
    public ResponseEntity<?> listById(@PathVariable int id){
        log.info("요청 들어옴 id : {}",id);
        List<CommentDTO> commentListById = commentService.findCommentListById(id);
        log.info("list : {}",commentListById);
        return ResponseEntity.ok(commentListById);
    }


}
