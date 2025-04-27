package com.example.hellospringboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {

    @NotBlank(message="Name is required")
    @Size(min=2, message="Name must be at least 2 characters long")
    private String name;

    public UserRequest(){

    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
