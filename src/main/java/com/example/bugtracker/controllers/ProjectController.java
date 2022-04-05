package com.example.bugtracker.controllers;


import com.example.bugtracker.models.Project;
import com.example.bugtracker.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/project")
@Controller
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping("/create")
    public String createProject(Project project){

        ModelAndView modelAndView = new ModelAndView();


        projectRepository.save(project);

        return "redirect:/";

    }

}
