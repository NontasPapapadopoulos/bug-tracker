package com.example.bugtracker.controllers;


import com.example.bugtracker.models.Bug;
import com.example.bugtracker.models.Project;
import com.example.bugtracker.models.User;
import com.example.bugtracker.repository.BugRepository;
import com.example.bugtracker.repository.ProjectRepository;
import com.example.bugtracker.service.BugService;
import com.example.bugtracker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/bug")
public class BugController {


    @Autowired
    private LogInController logInController;

    @Autowired
    private BugService bugService;



    @PostMapping("/create")
    public String createBug(Bug bug, Project project, User user, Model model){

        System.out.println(bug.getDescription());
        System.out.println(bug.getDescription());

        Long projectId = project.getProjectId();
        Long userId = user.getUserId();
        System.out.println(userId);
        System.out.println(projectId);


        bugService.createBug(bug, projectId, userId);

        return logInController.displayMainPage(model);

    }

    @GetMapping("/getBugsByProjectName")
    public void getBugsByProjectName(@RequestParam("projectName") String projectName) {

        System.out.println(projectName);

        bugService.getBugsByProjectName(projectName);

    }

}
