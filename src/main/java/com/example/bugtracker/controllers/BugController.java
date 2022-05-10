package com.example.bugtracker.controllers;


import com.example.bugtracker.models.Bug;
import com.example.bugtracker.models.Comment;
import com.example.bugtracker.models.Project;
import com.example.bugtracker.models.User;
import com.example.bugtracker.service.BugService;
import com.example.bugtracker.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bug")
public class BugController {


    @Autowired
    private LogInController logInController;

    @Autowired
    private BugService bugService;

    @Autowired
    private CommentService commentService;



    @PostMapping("/create")
    public String createBug(Bug bug, Project project, User user, Model model){

        Long projectId = project.getProjectId();
        Long userId = user.getUserId();

        bugService.createBug(bug, projectId, userId);

        return logInController.displayMainPage(model);
    }

    @GetMapping("/getBugsByProjectName")
    public ResponseEntity<Object> getBugsByProjectName(@RequestParam("projectName") String projectName) {

        List<Bug> bugs = bugService.getBugsByProjectName(projectName);
        return new ResponseEntity<Object>(bugs, HttpStatus.OK);
    }

    @GetMapping("/getBugDetails")
    public String getBugDetails(@RequestParam("bugId") Long bugId, Model model) {

        model.addAttribute("bug",bugService.getBugById(bugId).get());
        model.addAttribute("project",bugService.getBugById(bugId).get().getProject());
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", commentService.findAllCommentsByBugId(bugId));
        model.addAttribute("assignee", bugService.getBugById(bugId).get().getUser().getUsername());

        return "Comment";

    }

    @PostMapping("/updateBugStatus")
    public String updateBugStatus(@RequestParam("bugId") Long bugId, @RequestParam("status") String status, Model model) {

        bugService.updateBugStatus(bugId, status);


        return getBugDetails(bugId, model);
    }


}
