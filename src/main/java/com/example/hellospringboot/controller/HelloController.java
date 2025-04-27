package com.example.hellospringboot.controller;

import com.example.hellospringboot.dto.GreetRequest;
import com.example.hellospringboot.dto.GreetResponse;
import com.example.hellospringboot.service.GreetingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    private final GreetingService greetingService;

    public HelloController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String hello(){
        return this.greetingService.getGreeting(null);
    }

    @GetMapping("/greet")
    public String greetUser(@RequestParam(required = false) String name){
        return this.greetingService.getGreeting(name);
    }

    @PostMapping("/greet")
    public GreetResponse greetUserPost(@Valid @RequestBody GreetRequest request){
        String name = request.getName();
        return new GreetResponse(this.greetingService.getGreeting(name));
    }
}
