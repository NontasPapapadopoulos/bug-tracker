package com.example.bugtracker.controllers;

import com.example.bugtracker.models.User;
import com.example.bugtracker.repository.UserRepository;
import com.example.bugtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String displayRegister(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }


    @PostMapping("/saveUser")
    public String createEmployee(User user, Model model) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        if(!userService.userExists(user)) {
            userRepo.save(user);
            return "redirect:/";
        } else {
            return  displayRegister(model);
        }

    }
}
