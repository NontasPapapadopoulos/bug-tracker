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
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "project_date")
    private Date date;

    @Column(name = "project_description")
    private String description;

    @OneToMany(mappedBy = "project")
    private List<Bug> bugs;


    public Project(Long projectId, String projectName, String description) {
        this.projectName = projectName;
        this.description = description;
        this.date = Date.valueOf(LocalDate.now());
        this.projectId = projectId;
    }

    public Project( String projectName, String description) {
        this.projectName = projectName;
        this.description = description;
        this.date = Date.valueOf(LocalDate.now());
    }

    public Project() {

    }

    public List<Bug> getBugs() {
        return bugs;
    }

    public void setBugs(List<Bug> bugs) {
        this.bugs = bugs;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectName() {
        return projectName;
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
                ", projectName='" + projectName + '\'' +
                ", createdDate=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
