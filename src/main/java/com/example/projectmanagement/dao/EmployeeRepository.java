package com.example.projectmanagement.dao;

import com.example.projectmanagement.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
