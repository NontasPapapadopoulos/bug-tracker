package com.example.bugtracker.service;

import com.example.bugtracker.models.User;
import com.example.bugtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public Boolean userExists(User user) {
        Optional<User> requestedUsers =userRepository.findByUsername(user.getUsername());

        if (!requestedUsers.isPresent()) {
            return false;
        }
        return true;
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(RuntimeException::new);
    };
}
