package com.example.hellospringboot.controller;


import com.example.hellospringboot.dto.UserRequest;
import com.example.hellospringboot.dto.UserResponse;
import com.example.hellospringboot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request){
        UserResponse user = userService.createUser(request);

        URI location = URI.create("/users/" + user.getId());
        return ResponseEntity
                .created(location)
                .body(user);
    }

    @GetMapping
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id){
        UserResponse user = userService.getUserById(id);
        if (user == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String id){
        boolean deleted = userService.deleteUserById(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUserName(@PathVariable String id, @Valid @RequestBody UserRequest request){
        UserResponse updatedUser = userService.updateUserById(id, request.getName());
        if(updatedUser == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .ok(updatedUser);
    }
}
