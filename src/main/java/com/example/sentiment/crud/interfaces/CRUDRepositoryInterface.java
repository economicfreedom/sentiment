package com.example.sentiment.crud.interfaces;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CRUDRepositoryInterface<ENTITY>{

    int create(ENTITY entity);


    ENTITY findById(int id);


    int deleteById(int id);


    int update(ENTITY entity);


    List<ENTITY> findAll();


}
