package com.example.projectmanagement.dao;

import com.example.projectmanagement.dto.EmployeeProject;
import com.example.projectmanagement.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    public List<Employee> findAll();

    @Query(nativeQuery = true, value="SELECT e.id, e.first_name, COUNT(DISTINCT p.project_id) AS num_projects " +
            "FROM projects.employee e " +
            "JOIN projects.project_employee p ON e.id = p.employee_id " +
            "GROUP BY e.id, e.first_name " +
            "ORDER BY num_projects DESC;")
    public List<EmployeeProject> getEmployeeProjectsCount();

}
