package com.example.sentiment.crud.abs;

import com.example.sentiment.crud.interfaces.CRUDRepositoryInterface;
import com.example.sentiment.crud.interfaces.RestControllerInterface;
import org.springframework.http.ResponseEntity;

public abstract class CRUDAbstractApiController<DTO,ENTITY> implements RestControllerInterface<DTO> {



    @Override
    public ResponseEntity<?> create(DTO dto) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> findById(int id) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> deleteById(int id) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> update(DTO dto) {
        return ResponseEntity.ok().build();
    }
}
