package com.example.bugtracker.controllers;


import com.example.bugtracker.models.Bug;
import com.example.bugtracker.models.Project;
import com.example.bugtracker.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bug")
public class BugController {

    @Autowired
    private BugRepository bugRepository;

    @PostMapping("/create")
    public String createBug(Bug bug){

        bugRepository.save(bug);

        return "bugTracker";

    }

}
