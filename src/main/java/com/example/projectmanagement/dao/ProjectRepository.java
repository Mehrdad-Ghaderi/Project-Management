package com.example.projectmanagement.dao;

import com.example.projectmanagement.dto.ChartData;
import com.example.projectmanagement.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT projects.employee.id, COUNT(projects.project.stage) AS project_count " +
            "FROM employee " +
            "JOIN project " +
            "ON employee.id = project.id " +
            "GROUP BY employee.id ")
    List<ChartData> getProjectStatus();

}
