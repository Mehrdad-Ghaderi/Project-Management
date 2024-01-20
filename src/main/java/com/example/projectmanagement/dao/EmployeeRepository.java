package com.example.projectmanagement.dao;

import com.example.projectmanagement.dto.EmployeeProject;
import com.example.projectmanagement.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    public List<Employee> findAll();

    @Query(nativeQuery = true, value="SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) AS projectCount " +
            "From employee e left join project_employee pe ON pe.employee_id = employee_id " +
            "GROUP BY e.first_name, e.last_name ORDER BY 3 DESC ")
    public List<EmployeeProject> getEmployeeProjectsCount();

}
