package com.example.sentiment.crud.abs;

import com.example.sentiment.crud.interfaces.RestControllerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class CRUDAbstractApiController<DTO, ENTITY> implements RestControllerInterface<DTO> {

    @Autowired(required = false)
    private CRUDAbstractService<DTO, ENTITY> crudAbstractService;

    @PostMapping("/create")
    @Override
    public ResponseEntity<?> create(@RequestBody DTO dto) {
        int res = crudAbstractService.create(dto);

        if (res != 1){
            return ResponseEntity.badRequest().build();
        }


        return ResponseEntity.ok().build();
    }

    @GetMapping("/view/{id}")
    @Override
    public ResponseEntity<?> findById(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    @Override
    public ResponseEntity<?> update(@RequestBody DTO dto) {
        return ResponseEntity.ok().build();
    }
}
