package com.example.bugtracker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long commentId;
    @Column(name="comment_description")
    private String description;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name="comment_date")
    private LocalDateTime dateCreated;

    public Comment(){

    }

//    argotera tha mpei kai o user pou kanei to comment.

    public Comment(String description, Bug bug) {
        this.description = description;
        this.dateCreated = LocalDateTime.now();
        this.bug = bug;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Bug getBug() {
        return bug;
    }

    public void setBug(Bug bug) {
        this.bug = bug;
    }

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "bug_id")
    private Bug bug;







}
