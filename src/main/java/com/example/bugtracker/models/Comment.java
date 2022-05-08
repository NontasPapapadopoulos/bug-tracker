package com.example.bugtracker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long commentId;
    @Column(name="comment_description")
    private String description;

    @Column(name="comment_date")
    private Date dateCreated;

    public Comment(){

    }

//    argotera tha mpei kai o user pou kanei to comment.

    public Comment(String description, Bug bug) {
        this.description = description;
        this.dateCreated = java.sql.Date.valueOf(LocalDate.now());
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
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
