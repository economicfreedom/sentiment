package com.example.sentiment.crud.abs;

import com.example.sentiment.crud.interfaces.ControllerInterface;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public abstract class CRUDAbstractController<DTO,ENTITY> implements ControllerInterface<DTO> {

    private CRUDAbstractService<DTO,ENTITY> crudAbstractService;

    @GetMapping("/")
    @Override
    public String list(Model model) {
        List<DTO> list = crudAbstractService.findAll();

        model.addAttribute("list",list);

        return getBasePath()+ "board/list";
    }

    @GetMapping("/view/{id}")
    @Override
    public String viewPage(Model model,@PathVariable int id) {

        return getBasePath()+"/view";
    }

    @PostMapping("/create")
    @Override
    public String createPage(Model model) {
        return getBasePath()+"/create";
    }

    @PutMapping("/update")
    @Override
    public String updatePage(Model model,DTO dto) {
        return getBasePath()+"/update";
    }
    protected abstract String getBasePath();

}
