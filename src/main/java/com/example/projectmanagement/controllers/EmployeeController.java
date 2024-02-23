package com.example.projectmanagement.controllers;

import com.example.projectmanagement.entities.Employee;
import com.example.projectmanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model) {
        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/list")
    public String displayEmployees(Model model) {
        var employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        return "employees/employees-list";
    }
}
