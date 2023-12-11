package com.example.sentiment.crud.interfaces;

import java.util.List;

public interface CRUDInterface <DTO> {

    int create(DTO dto);
    DTO findById(int id);
    int deleteById(int id);
    int update(DTO dto);
    List<DTO> findAll();





}
