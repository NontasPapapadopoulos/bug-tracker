package com.example.bugtracker.models;

import javax.persistence.*;
import java.util.List;


@Entity
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bugId;
    private BugStatus status;
    //private ArrayList<Comment> comments;
    private String description;
    private String name;


    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="user_id")
    public User user;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="project_id")
    private Project project;


    public Bug(String bugName, String description) {
        this.name = bugName;
        this.description = description;
        this.status = BugStatus.UNRESOLVED;

    }

    public Bug() {

    }


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public Long getBugId() {
        return bugId;
    }



    public BugStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }


    public String getName() {
        return name;
    }
}
