package com.example.hellospringboot.service;

import com.example.hellospringboot.dto.UserRequest;
import com.example.hellospringboot.dto.UserResponse;
import com.example.hellospringboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserRequest request){
        return userRepository.save(request.getName());
    }

    public List<UserResponse> getAllUsers(){
        return userRepository.findAll();
    }

    public UserResponse getUserById(String id){
        return userRepository.findById(id);
    }

    public boolean deleteUserById(String id){
        return userRepository.deleteById(id);
    }

    public UserResponse updateUserById(String id, String name){
        return userRepository.updateNameById(id, name);
    }
}