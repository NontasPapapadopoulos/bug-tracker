package com.example.bugtracker.repository;

import com.example.bugtracker.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long > {
}
