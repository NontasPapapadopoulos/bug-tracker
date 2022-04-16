package com.example.bugtracker.repository;

import com.example.bugtracker.models.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long > {

    //@Query("Select * from project where project_id =:id")
    Project getProjectByProjectId(@Param("id") Long id);
}
