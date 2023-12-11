package com.example.sentiment.crud.abs;

import com.example.sentiment.crud.interfaces.CRUDRepositoryInterface;
import com.example.sentiment.crud.interfaces.ControllerInterface;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public abstract class CRUDAbstractController<DTO,ENTITY> implements ControllerInterface<DTO> {

    private CRUDAbstractService<DTO,ENTITY> crudAbstractService;

    @GetMapping("/")
    @Override
    public String list() {

        return getBasePath()+"/list";
    }

    @GetMapping("/view/{id}")
    @Override
    public String viewPage(@PathVariable int id) {

        return getBasePath()+"/view";
    }

    @PostMapping("/create")
    @Override
    public String createPage() {
        return getBasePath()+"/create";
    }

    @PutMapping("/update")
    @Override
    public String updatePage(DTO dto) {
        return getBasePath()+"/update";
    }
    protected abstract String getBasePath();

}
