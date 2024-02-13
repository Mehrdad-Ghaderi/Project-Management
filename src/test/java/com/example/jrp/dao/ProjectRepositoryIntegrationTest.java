package com.example.jrp.dao;

import com.example.projectmanagement.ProjectManagementApplication;
import com.example.projectmanagement.dao.ProjectRepository;
import com.example.projectmanagement.entities.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@ContextConfiguration(classes = ProjectManagementApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectRepositoryIntegrationTest {
    @Autowired
    ProjectRepository projectRepository;

    @Test
    public void ifNewProjectSaved_success() {
        Project project = new Project("New Test Project", "COMPLETE", "Test description");
        projectRepository.save(project);

        assertEquals(5, projectRepository.findAll().size());

    }
}
