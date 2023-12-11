package com.example.sentiment.crud.abs;

import com.example.sentiment.crud.interfaces.CRUDInterface;
import com.example.sentiment.crud.interfaces.CRUDRepositoryInterface;
import com.example.sentiment.crud.interfaces.Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public abstract class CRUDAbstractService<DTO, ENTITY> implements CRUDInterface<DTO> {


    private CRUDRepositoryInterface<DTO, ENTITY> repository;

    private Converter<DTO, ENTITY> converter;

    @Autowired(required = false)
    public CRUDAbstractService(CRUDRepositoryInterface<DTO, ENTITY> repository, Converter<DTO, ENTITY> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public int create(DTO dto) {
        // dto -> entity
        var entity = converter.toEntity(dto);

        return repository.create(entity);

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
        List<DTO> all = repository.findAll();
        log.info("내용 : {}",all);
        return all;
    }
}
