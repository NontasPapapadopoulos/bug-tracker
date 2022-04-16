package com.example.bugtracker.controllers;


import com.example.bugtracker.models.Bug;
import com.example.bugtracker.models.Project;
import com.example.bugtracker.models.User;
import com.example.bugtracker.repository.BugRepository;
import com.example.bugtracker.repository.ProjectRepository;
import com.example.bugtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class LogInController {

    @Autowired
    private ProjectRepository projectRepo ;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BugRepository bugRepo;


    @GetMapping("/")
    public String displayLogInPage() {

        return "index";
    }

    @GetMapping("/main")
    public String displayMainPage(Model model ) {
        List<Project> projects = (List<Project>) projectRepo.findAll();
        List<User> users = (List<User>) userRepo.findAll();

        Project project = new Project();

        Bug bug = new Bug();

        model.addAttribute("projects", projects);
        model.addAttribute("project", project);
        model.addAttribute("users", users);
        model.addAttribute("bug",bug);
        return "bugTracker";
    }


    @PostMapping("/bugTracker")
    public String renderBugTracker(Model model) {

        List<Project> projects = (List<Project>) projectRepo.findAll();
        List<User> users = (List<User>) userRepo.findAll();

        Project project = new Project();

        Bug bug = new Bug();

        model.addAttribute("projects", projects);
        model.addAttribute("project", project);
        model.addAttribute("users", users);
        model.addAttribute("bug",bug);

    //    System.out.println(model.getAttribute());
        System.out.println(bugRepo.findAll());

    return "bugTracker";
    }


}
