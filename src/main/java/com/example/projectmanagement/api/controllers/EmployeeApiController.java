package com.example.projectmanagement.api.controllers;

import com.example.projectmanagement.entities.Employee;
import com.example.projectmanagement.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
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
    public Employee create(@RequestBody @Valid Employee employee) { //in the body there will be an employee
        return employeeService.save(employee);
    }

    @PutMapping(path = "/{id}", consumes = "application/json")
    //consume is not necessary, Spring is smart enough to know we are dealing with a JSON
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid Employee employee) {
        employeeService.save(employee);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Employee partialUpdate(@PathVariable("id") String id, @RequestBody @Valid Employee patchEmployee) {
        Employee emp = employeeService.findById(id);

        if (patchEmployee.getEmail() != null) {
            emp.setEmail(patchEmployee.getEmail());
        }
        if (patchEmployee.getFirstName() != null) {
            emp.setFirstName(patchEmployee.getFirstName());
        }
        if (patchEmployee.getLastName() != null) {
            emp.setLastName(patchEmployee.getLastName());
        }

        return employeeService.save(emp);
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

    /*@GetMapping(params = {"page", "size"})
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Employee> findPaginatedEmployees(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageAndSize = (Pageable) PageRequest.of(page, size);

        return employeeService.findAll(pageAndSize);
    }*/
}
