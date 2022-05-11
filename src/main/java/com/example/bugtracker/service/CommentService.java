package com.example.bugtracker.service;

import com.example.bugtracker.models.Bug;
import com.example.bugtracker.models.Comment;
import com.example.bugtracker.repository.BugRepository;
import com.example.bugtracker.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BugRepository bugRepository;

    public void addComment(String commentDescription, Long bugId) throws ParseException {

        Bug bug = bugRepository.findById(bugId).orElseThrow(RuntimeException::new);

        Comment comment = new Comment(commentDescription, bug);

        if (comment.getDescription()!=null && !comment.getDescription().trim().isEmpty() ) {
            commentRepository.save(comment);
        }


    }

    public List<Comment> findAllCommentsByBugId(Long bugId) {
        return commentRepository.findAllCommentsByBugId(bugId);

    }
}
