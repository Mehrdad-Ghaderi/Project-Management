package com.example.projectmanagement.api.controllers;

import com.example.projectmanagement.entities.Project;
import com.example.projectmanagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app-api/projects")
public class ProjectApiController {

    @Autowired
    ProjectService projectService;

    @GetMapping
    public List<Project> getProjects() {
        return projectService.findAll();
    }
}
