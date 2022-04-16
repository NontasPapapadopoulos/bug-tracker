package com.example.bugtracker.service;

import com.example.bugtracker.models.Bug;
import com.example.bugtracker.models.BugStatus;
import com.example.bugtracker.models.Project;
import com.example.bugtracker.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BugService {

    @Autowired
    private BugRepository bugRepository;


    public void createBug(Bug bug, Project project) {



        Bug newBug = new Bug(bug.getName(), bug.getDescription(), project);

        System.out.println(newBug);

        bugRepository.save(newBug);

    }

}
