package com.example.sentiment.repository.interfaces;

import com.example.sentiment.crud.interfaces.CRUDRepositoryInterface;
import com.example.sentiment.dto.comment.CommentDTO;
import com.example.sentiment.repository.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentRepository extends CRUDRepositoryInterface<Comment> {
    @Override
    int create(Comment commentDTO);

    @Override
    Comment findById(int id);

    @Override
    int deleteById(int id);


    @Override
    int update(Comment comment);

    @Override
    List<Comment> findAll();


    List<Comment> findListById(int id);

}
