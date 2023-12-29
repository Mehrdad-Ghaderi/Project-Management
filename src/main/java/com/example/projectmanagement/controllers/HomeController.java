package com.example.projectmanagement.controllers;

import com.example.projectmanagement.dao.ProjectRepository;
import com.example.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/")
    public String displayHome(Model model) {
        List<Project> projectList = projectRepository.findAll();
        model.addAttribute("projectList", projectList);
        return "main/home";
    }
}
