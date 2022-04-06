package com.example.bugtracker.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long userId;
    private String username;
    private String password;
    private String job;
    private String email;

    public List<Bug> getBugs() {
        return bugs;
    }

    public void setBugs(List<Bug> bugs) {
        this.bugs = bugs;
    }

    @OneToMany(mappedBy = "user")
    private List<Bug> bugs;



    public User(String username, String password, String job, String email) {
        this.username = username;
        this.password = password;
        this.job = job;
        this.email = email;
    }

    public User(Long userId, String username, String password, String job, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.job = job;
        this.email = email;
    }

    public User(String username, Long userId) {
        this.username = username;
        this.userId = userId;
    }

    public User() {

    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", job='" + job + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
