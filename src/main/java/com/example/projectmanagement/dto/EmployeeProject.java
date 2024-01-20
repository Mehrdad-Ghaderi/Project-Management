package com.example.projectmanagement.dto;

public interface EmployeeProject {

    //properties need to start with get so Spring Data knows this DTO needs to be used to a table
    String getFirstName();
    String getLastName();
    int getProjectCount();
}
