package com.example.bugtracker.models;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Entity
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bugId;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private BugStatus status;

    private String description;
    private String name;
    private Date date;


    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "project_id")
    private Project project;


    public Bug(String bugName, String description, Project project) {
        this.name = bugName;
        this.description = description;
        this.status = BugStatus.UNRESOLVED;
        this.date = Date.valueOf(LocalDate.now());
        this.project = project;
    }

    public Bug() {

    }


    public Long getBugId() {
        return bugId;
    }

    public void setBugId(Long bugId) {
        this.bugId = bugId;
    }

    public BugStatus getStatus() {
        return status;
    }

    public void setStatus(BugStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
