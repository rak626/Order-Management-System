package com.dev.inktown.service;


import com.dev.inktown.entity.User;
import com.dev.inktown.entity.User;
import com.dev.inktown.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public User getUserById(String userId){
        Optional<User> result = userRepository.findById(userId);
        return result.orElseGet(User::new);
    }
    public User createUser(User newUser){
        return userRepository.save(newUser);
    }

   
}
