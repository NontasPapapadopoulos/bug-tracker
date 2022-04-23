package com.example.bugtracker.models;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "bug")
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bugId;

    @Column(name="bug_status")
    @Enumerated(EnumType.STRING)
    private BugStatus status;

    @Column(name = "bug_description")
    private String description;

    @Column(name = "bug_name")
    private String bugName;

    @Column(name = "bug_date")
    private Date date;


    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "project_id")
    private Project project;


    public Bug(String bugName, String description, Project project, User user) {
        this.bugName = bugName;
        this.description = description;
        this.status = BugStatus.UNRESOLVED;
        this.date = Date.valueOf(LocalDate.now());
        this.project = project;
        this.user = user;
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

    public String getBugName() {
        return bugName;
    }

    public void setBugName(String name) {
        this.bugName = name;
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
