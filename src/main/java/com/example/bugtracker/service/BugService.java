package com.example.bugtracker.service;

import com.example.bugtracker.models.Bug;
import com.example.bugtracker.models.BugStatus;
import com.example.bugtracker.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BugService {

    @Autowired
    private BugRepository bugRepository;


    public void createBug(Bug bug) {

        String name =bug.getName();
        String description = bug.getDescription();
        Long projectId = bug.getProject().getProjectId();

        BugStatus status = BugStatus.UNRESOLVED;
        Long userId = bug.getUser().getUserId();

        Bug newBug = new Bug(name, description);

    }

}
