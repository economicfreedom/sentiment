package com.example.sentiment.crud.abs;

import com.example.sentiment.crud.interfaces.CRUDInterface;
import com.example.sentiment.crud.interfaces.CRUDRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class CRUDAbstractService<DTO, ENTITY> implements CRUDInterface<DTO> {


    protected final CRUDRepositoryInterface<DTO, ENTITY> repository;

    @Autowired
    public CRUDAbstractService(CRUDRepositoryInterface<DTO, ENTITY> repository) {
        this.repository = repository;
    }

    @Override
    public int create(DTO dto) {
        return 0;
    }

    @Override
    public DTO findById(int id) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public int update(DTO dto) {
        return 0;
    }

    @Override
    public List<DTO> findAll() {
        return null;
    }
}
