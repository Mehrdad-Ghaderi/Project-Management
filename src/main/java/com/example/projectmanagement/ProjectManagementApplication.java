package com.example.projectmanagement;

import com.example.projectmanagement.dao.EmployeeRepository;
import com.example.projectmanagement.dao.ProjectRepository;
import com.example.projectmanagement.entities.Employee;
import com.example.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ProjectManagementApplication {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProjectRepository projectRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Employee employee1 = new Employee("Mehrdad", "Ghaderi", "mehrdad.ghaderi@yahoo.com");
            Employee employee2 = new Employee("Selda", "Basser", "seldabasser@gmail.com");
            Employee employee3 = new Employee("Mehdi", "Rostami", "m.rostamy@gmail.com");
            Employee employee4 = new Employee("Nicole", "Kidman", "nicole.kidman@yahoo.com");
            Employee employee5 = new Employee("Robert", "DeNiro", "rob@rob.com");
            Employee employee6 = new Employee("Sugar", "Cane", "sc@gmail.com");
            Employee employee7 = new Employee("Martin", "Scorsese", "M.scor@hollywood.com");
            Employee employee8 = new Employee("Denzel", "Washington", "dw@dw.com");
            Employee employee9 = new Employee("Lana", "Dalila", "Ld@hw.com");

            Project project1 = new Project("Large Production Deploy", "NOT STARTED", "This requires" +
                    "all hands on deck for the final deployment of the software into production.");
            Project project2 = new Project("New Employee Budget", "COMPLETED", "Decide on a new " +
                    "employee bonus budget for the year and figure out who deserves to be promoted.");
            Project project3 = new Project("Office Reconstruction", "INPROGRESS", "The office building " +
                    "in New York need renovation due to low maintenance budget.");
            Project project4 = new Project("Improve Internet Security", "INPROGRESS", "Our data has been " +
                    "hacked and we need urgent security improvement.");

            project1.addEmployee(employee1);
            project1.addEmployee(employee2);
            project2.addEmployee(employee3);
            project3.addEmployee(employee1);
            project4.addEmployee(employee1);
            project4.addEmployee(employee3);

            employee1.setProjects(Arrays.asList(project1, project3, project4));
            employee2.setProjects(Arrays.asList(project1));
            employee3.setProjects(Arrays.asList(project2, project4));

            employeeRepository.save(employee1);
            employeeRepository.save(employee2);
            employeeRepository.save(employee3);
            employeeRepository.save(employee4);
            employeeRepository.save(employee5);
            employeeRepository.save(employee6);
            employeeRepository.save(employee7);
            employeeRepository.save(employee8);
            employeeRepository.save(employee9);

            projectRepository.save(project1);
            projectRepository.save(project2);
            projectRepository.save(project3);
            projectRepository.save(project4);
            };
        }
}
