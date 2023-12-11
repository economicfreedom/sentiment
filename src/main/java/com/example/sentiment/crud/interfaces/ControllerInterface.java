package com.example.sentiment.crud.interfaces;

import org.springframework.ui.Model;

public interface ControllerInterface<DTO> {
    

    public String list(Model model);

    public String viewPage(Model model,int id);

    
    public String createPage(Model model);

    
    public String updatePage(Model model,DTO dto);
    
}
