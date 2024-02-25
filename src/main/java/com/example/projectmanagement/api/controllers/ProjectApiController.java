package com.example.projectmanagement.api.controllers;

import com.example.projectmanagement.entities.Employee;
import com.example.projectmanagement.entities.Project;
import com.example.projectmanagement.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable("id") String id) {
        return projectService.findById(id);
    }

    @PostMapping(consumes = "application/json")
    public Project create(@RequestBody @Valid Project project) {
        return projectService.save(project);
    }

    @PutMapping(consumes = "application/json")
    // it updates the entire record and relational tables might be lost
    public void update(@RequestBody @Valid Project project) {
        projectService.save(project);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Project partialUpdate(@PathVariable("id") String id, @RequestBody @Valid Project patchProject) {
        var project = projectService.findById(id);

        if (patchProject.getStage() != null) {
            project.setStage(patchProject.getStage());
        }
        if (patchProject.getDescription() != null) {
            project.setDescription(patchProject.getDescription());
        }
        if (patchProject.getName() != null) {
            project.setStage(patchProject.getStage());
        }

        return projectService.save(project);
    }

    @DeleteMapping(path = "/{id}", consumes = "application/json")
    public void delete(@PathVariable("id") String id) {
        try {
            projectService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
    }
}
