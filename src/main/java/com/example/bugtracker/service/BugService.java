package com.example.bugtracker.service;

import com.example.bugtracker.models.Bug;
import com.example.bugtracker.models.Project;
import com.example.bugtracker.models.User;
import com.example.bugtracker.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class BugService {

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    public void createBug(Bug bug, Long projectId, Long userId) {

        Project selectedProject = projectService.getProjectById(projectId);

        User selectedUser = userService.getUserById(userId);
        Bug newBug = new Bug(bug.getBugName(), bug.getDescription(), selectedProject, selectedUser);

        System.out.println(newBug);

        bugRepository.save(newBug);

    }

    public HashMap<String, Long> bugStatus () {
        HashMap<String, Long> map = new HashMap<>();
        Long totalBugs = bugRepository.count();
        Long underTesting = bugRepository.getUnderTestingBugs();
        Long resolvedBugs = bugRepository.getResolvedBugs();
        Long unresolvedBugs = bugRepository.getUnresolvedBugs();

        map.put("totalBugs", totalBugs);
        map.put("underTesting", underTesting);
        map.put("resolvedBugs", resolvedBugs);
        map.put("unresolvedBugs", unresolvedBugs);

        return map;
    }


    public List<Bug> getBugsByProjectName(String projectName){
        return bugRepository.getBugsByProjectName(projectName);
    }

    public Optional<Bug> getBugById(Long id) {
        return bugRepository.findById(id);
    }

    public void updateBugStatus(Long id, String status) {
        bugRepository.updateBugStatus(id, status);
    }

}
