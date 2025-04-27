package com.example.hellospringboot.repository;

import com.example.hellospringboot.dto.UserResponse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {

    private final List<UserResponse> users = new ArrayList<>();

    public UserResponse save(String name){
        UserResponse user = new UserResponse((UUID.randomUUID().toString()), name);
        users.add(user);
        return user;
    }

    public List<UserResponse> findAll(){
        return users;
    }

    public UserResponse findById(String id){
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean deleteById(String id){
        return users.removeIf(user -> user.getId().equals(id));
    }

    public UserResponse updateNameById(String id, String name){
        UserResponse user = findById(id);
        if(user != null){
            user.setName(name);
            return user;
        }
        return null;
    }
}
