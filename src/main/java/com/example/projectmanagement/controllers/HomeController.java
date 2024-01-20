package com.example.projectmanagement.controllers;

import com.example.projectmanagement.dao.EmployeeRepository;
import com.example.projectmanagement.dao.ProjectRepository;
import com.example.projectmanagement.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/home")
    public String displayHome(Model model) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();

        List<Project> projectList = projectRepository.findAll();
        model.addAttribute("projectList", projectList);

        var chartData = projectRepository.getProjectStatus();
        //converting chartData to JSON for JS
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(chartData);
        //the former method creates this: {["NOTSTARTED",1], ["COMPLETED", 2], ["INPROGRESS", 4]}

        model.addAttribute("projectStatusCount", jsonString);

        var employeeProjectsCount = employeeRepository.getEmployeeProjectsCount();
        model.addAttribute("employeesProjectCount", employeeProjectsCount);
        return "main/home";
    }
}
