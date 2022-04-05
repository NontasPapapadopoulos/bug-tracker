package com.example.bugtracker.models;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;
    private String name;
    private Date date;
    private String description;

    @OneToMany(mappedBy = "project")
    private List<Bug> bugs;


    public Project(Long projectId, String projectName, String description) {
        this.name = projectName;
        this.description = description;
        this.date = Date.valueOf(LocalDate.now());
        this.projectId = projectId;
    }

    public Project( String projectName, String description) {
        this.name = projectName;
        this.description = description;
        this.date = Date.valueOf(LocalDate.now());
    }

    public Project() {

    }

    public Long getProjectId() {
        return projectId;
    }

    public void setName(String projectName) {
        this.name = projectName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
         return  this.date;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + name + '\'' +
                ", createdDate=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
