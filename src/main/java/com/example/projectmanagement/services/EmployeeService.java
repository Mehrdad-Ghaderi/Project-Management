package com.example.projectmanagement.services;

import com.example.projectmanagement.dao.EmployeeRepository;
import com.example.projectmanagement.dto.EmployeeProject;
import com.example.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public List<EmployeeProject> getEmployeeProjects() {
        return employeeRepository.getEmployeeProjects();
    }


}
