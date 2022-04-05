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
    private Long projectId;
    private String name;


    //@ElementCollection
    @ManyToOne
    @JoinColumn(name="user_id")
    public User user;




    public Bug(String bugName, String description, Long projectId) {
        this.name = bugName;
        this.description = description;
        this.projectId = projectId;
        this.status = BugStatus.UNRESOLVED;

    }

    public Bug() {

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

    public Long getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }
}
