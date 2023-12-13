package com.example.sentiment.crud.abs;

import com.example.sentiment.crud.interfaces.CRUDInterface;
import com.example.sentiment.crud.interfaces.CRUDRepositoryInterface;
import com.example.sentiment.crud.interfaces.Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public abstract class CRUDAbstractService<DTO, ENTITY> implements CRUDInterface<DTO> {


    private CRUDRepositoryInterface<ENTITY> repository;

    private Converter<DTO, ENTITY> converter;

    @Autowired(required = false)
    public CRUDAbstractService(CRUDRepositoryInterface<ENTITY> repository, Converter<DTO, ENTITY> converter) {
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
        ENTITY entity = repository.findById(id);
        if (entity == null) {
            throw new IllegalArgumentException("존재 하지 않습니다");
        }

        return converter.toDto(entity);
    }

    @Override
    public int deleteById(int id) {

        return repository.deleteById(id);
    }

    @Override
    public int update(DTO dto) {
        ENTITY entity = converter.toEntity(dto);


        return repository.update(entity);
    }

    @Override
    public List<DTO> findAll() {
        List<ENTITY> all = repository.findAll();

        return all.stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }
}
