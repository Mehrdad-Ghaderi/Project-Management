package com.example.projectmanagement.controllers;

import com.example.projectmanagement.dao.EmployeeRepository;
import com.example.projectmanagement.dao.ProjectRepository;
import com.example.projectmanagement.entities.Employee;
import com.example.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("project", new Project());
        model.addAttribute("employees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {


        projectRepository.save(project);

        return "redirect:/projects/list";
    }

    @GetMapping("/list")
    public String displayProjects(Model model) {
        var projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        return "projects/projects-list";
    }
}
