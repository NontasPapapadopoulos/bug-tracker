package com.example.bugtracker.controllers;


import com.example.bugtracker.models.Bug;
import com.example.bugtracker.models.Project;
import com.example.bugtracker.models.User;
import com.example.bugtracker.repository.ProjectRepository;
import com.example.bugtracker.repository.UserRepository;
import com.example.bugtracker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/project")
@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private LogInController logInController;

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private UserRepository userRepo;


    @PostMapping("/create")
    public String createProject(Project project, Model model){
        projectService.createProject(project);
        List<Project> projects = (List<Project>) projectRepo.findAll();
        List<User> users = (List<User>) userRepo.findAll();

        Project aProject = new Project();

        Bug bug = new Bug();

        model.addAttribute("projects", projects);
        model.addAttribute("project", aProject);
        model.addAttribute("users", users);
        model.addAttribute("bug",bug);
        return "bugTracker";


    }



}
