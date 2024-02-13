package com.example.projectmanagement.services;

import com.example.projectmanagement.dao.ProjectRepository;
import com.example.projectmanagement.dto.ChartData;
import com.example.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public List<ChartData> getProjectStatus() {
        return projectRepository.getProjectStatus();
    }
}
