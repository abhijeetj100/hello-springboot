package com.example.hellospringboot.dto;

public class GreetResponse {
    private String message;

    public GreetResponse(String msg){
        this.message = msg;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String msg){
        this.message = msg;
    }

}
