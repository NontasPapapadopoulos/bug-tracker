package com.example.bugtracker.models;


import javax.persistence.Embeddable;

//@Embeddable
public enum BugStatus {
    UNRESOLVED  ,
    UNDER_TESTING ,
    RESOLVED
}
