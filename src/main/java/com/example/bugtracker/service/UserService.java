package com.example.bugtracker.service;

import com.example.bugtracker.models.User;
import com.example.bugtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(RuntimeException::new);
    };
}
