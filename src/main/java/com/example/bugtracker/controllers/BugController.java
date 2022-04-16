package com.example.bugtracker.controllers;


import com.example.bugtracker.models.Bug;
import com.example.bugtracker.models.Project;
import com.example.bugtracker.repository.ProjectRepository;
import com.example.bugtracker.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/bug")
public class BugController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private LogInController logInController;

    @Autowired
    private BugService bugService;

    @PostMapping("/create")
    public String createBug(Bug bug, Project project, Model model){

        Long projectId = project.getProjectId();
        Optional<Project> project1 =  projectRepository.findById(projectId);
        System.out.println(projectRepository.getProjectByProjectId(projectId));


        return logInController.displayMainPage(model);

    }

}
