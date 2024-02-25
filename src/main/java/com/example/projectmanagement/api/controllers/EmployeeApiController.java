package com.example.projectmanagement.api.controllers;

import com.example.projectmanagement.entities.Employee;
import com.example.projectmanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id) {
        return employeeService.findById(id);
    }

    @PostMapping(consumes = "application/json")  //it consumes a json
    //@ResponseStatus(HttpStatus.CREATED) //to change the code eg. 200 400 500 to 201, 401 ...
    public Employee create(@RequestBody Employee employee) { //in the body there will be an employee
        return employeeService.save(employee);
    }

    @PutMapping(path = "/{id}", consumes = "application/json")
    //consume is not necessary, Spring is smart enough to know we are dealing with a JSON
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        try {
            employeeService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
    }

}