package com.example.projectmanagement.dao;

import com.example.projectmanagement.dto.EmployeeProject;
import com.example.projectmanagement.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    public List<Employee> findAll();

    @Query(nativeQuery = true, value="SELECT e.first_name AS firstName, e.last_name AS lastName, COUNT(pe.employee_id) AS projectCount " +
            "FROM projects.employee e LEFT JOIN projects.project_employee pe ON (pe.employee_id = e.id) " +
            "GROUP BY e.first_name, e.last_name ORDER BY 3 DESC ")
    public List<EmployeeProject> getEmployeeProjects();

    Employee findByEmail(String value);
}
