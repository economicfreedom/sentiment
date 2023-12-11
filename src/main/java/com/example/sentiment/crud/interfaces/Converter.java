package com.example.sentiment.crud.interfaces;

public interface Converter<DTO,ENTITY> {
    DTO toDto(ENTITY entity);
    ENTITY toEntity(DTO dto);
}
