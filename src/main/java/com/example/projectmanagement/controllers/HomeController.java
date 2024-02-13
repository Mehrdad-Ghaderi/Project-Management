package com.example.projectmanagement.controllers;

import com.example.projectmanagement.entities.Project;
import com.example.projectmanagement.services.EmployeeService;
import com.example.projectmanagement.services.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    //This "version" is read from the application.properties file
    @Value("${version}")
    private String ver;

    @Autowired
    ProjectService projectService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/home")
    public String displayHome(Model model) throws JsonProcessingException {
        model.addAttribute("versionNumber", ver);

        List<Project> projectList = projectService.getAll();
        model.addAttribute("projectList", projectList);

        //The second Type is Object because we want it to be generic
        Map<String, Object> map = new HashMap<>();
        var projectData = projectService.getProjectStatus();

        //converting projectData to JSON for JS
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        //the former method creates this: {["NOTSTARTED",1], ["COMPLETED", 2], ["INPROGRESS", 4]}
        model.addAttribute("projectStatusCount", jsonString);

        var employeeProjectsCount = employeeService.getEmployeeProjects();
        model.addAttribute("employeesListProjectCount", employeeProjectsCount);
        return "main/home";
    }
}
