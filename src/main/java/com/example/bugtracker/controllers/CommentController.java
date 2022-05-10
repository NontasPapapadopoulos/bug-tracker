package com.example.bugtracker.controllers;


import com.example.bugtracker.models.Comment;
import com.example.bugtracker.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {


    @Autowired
    CommentService commentService;

    @Autowired
    BugController bugController;

    @PostMapping("/addComment")
    public String addComment(@RequestParam("description") String description, @RequestParam("bugId") Long bugId , Model model) {
        commentService.addComment(description, bugId);



        return bugController.getBugDetails(bugId, model
    }

}
