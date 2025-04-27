package com.example.hellospringboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class GreetRequest {

    @NotBlank(message = "Name cannot be blank")
    @Size(min=2, message="Name must be at least 2 characters long")
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
