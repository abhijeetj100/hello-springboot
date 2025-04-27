package com.example.hellospringboot.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreeting(String name){
        if(name == null || name.isEmpty()){
            return "Hello, Guest!";
        }
        return "Hello "+name+", from GreetingService Bean!";
    }
}
