package com.example.bugtracker.service;

import com.example.bugtracker.models.Project;
import com.example.bugtracker.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public void createProject(Project project){

        String name =project.getProjectName();
        String description = project.getDescription();

        Project newProject = new Project(name, description);

        projectRepository.save(newProject);
    }


    public Project getProjectById(Long projectId){
        return projectRepository.findById(projectId).orElseThrow(RuntimeException::new);
    }
}
