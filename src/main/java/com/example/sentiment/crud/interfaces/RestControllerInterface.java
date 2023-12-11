package com.example.sentiment.crud.interfaces;

import org.springframework.http.ResponseEntity;

public interface RestControllerInterface<DTO> {

    ResponseEntity<?> create(DTO dto);

    ResponseEntity<?> findById(int id);

    ResponseEntity<?> deleteById(int id);

    ResponseEntity<?> update(DTO dto);

}
