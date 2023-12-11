package com.example.sentiment.crud.interfaces;

public interface ControllerInterface<DTO> {
    

    public String list();

    public String viewPage(int id);

    
    public String createPage();

    
    public String updatePage(DTO dto);
    
}
