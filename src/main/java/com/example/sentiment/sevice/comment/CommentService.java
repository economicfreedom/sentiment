package com.example.sentiment.sevice.comment;

import com.example.sentiment.crud.abs.CRUDAbstractService;
import com.example.sentiment.crud.interfaces.CRUDRepositoryInterface;
import com.example.sentiment.crud.interfaces.Converter;
import com.example.sentiment.dto.comment.CommentDTO;
import com.example.sentiment.repository.interfaces.CommentRepository;
import com.example.sentiment.repository.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService extends CRUDAbstractService<CommentDTO, Comment> {

 private final CommentRepository commentRepository;
    private final Converter<CommentDTO, Comment> converter;

    public CommentService(CommentRepository commentRepository, Converter<CommentDTO, Comment> converter) {
        super(commentRepository, converter);
        this.commentRepository = commentRepository;
        this.converter = converter;
    }
    public List<CommentDTO> findCommentListById(int id){

        return commentRepository.findListById(id).stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

}
