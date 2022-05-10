package com.example.bugtracker.service;

import com.example.bugtracker.models.Bug;
import com.example.bugtracker.models.Comment;
import com.example.bugtracker.repository.BugRepository;
import com.example.bugtracker.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BugRepository bugRepository;

    public void addComment(String commentDescription, Long bugId) {

        Bug bug = bugRepository.findById(bugId).orElseThrow(RuntimeException::new);
        Comment comment = new Comment(commentDescription, bug);

        System.out.println(comment.getDateCreated());
        commentRepository.save(comment);
    }

    public List<Comment> findAllCommentsByBugId(Long bugId) {
        return commentRepository.findAllCommentsByBugId(bugId);

    }
}
