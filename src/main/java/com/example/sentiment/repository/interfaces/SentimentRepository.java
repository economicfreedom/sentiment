package com.example.sentiment.repository.interfaces;


import com.example.sentiment.crud.interfaces.CRUDRepositoryInterface;
import com.example.sentiment.dto.sentiment.SentimentDTO;
import com.example.sentiment.repository.model.Sentiment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SentimentRepository extends CRUDRepositoryInterface<Sentiment> {

    @Override
    int create(Sentiment entity);

    @Override
    Sentiment findById(int id);

    @Override
    int deleteById(int id);

    @Override
    int update(Sentiment sentiment);

    @Override
    List<Sentiment> findAll();

    Sentiment findByBoardId(int boardId);
}
