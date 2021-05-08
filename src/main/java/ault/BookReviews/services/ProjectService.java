package ault.BookReviews.services;

import ault.BookReviews.repositories.*;
import ault.BookReviews.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ProjectService {
    private final ProjectRepository projectDao;

    @Autowired
    public ProjectService(ProjectRepository projectDao) {
        this.projectDao = projectDao;
    }

    @Transactional
    public Optional<Project> project(String id) {
      return projectDao.findById(id);
    }

    @Transactional
    public List<Project> projects() {
      return projectDao.findAll();
    }

    @Transactional
    public long projectCount() {
      return projectDao.count();
    }

    @Transactional
    public String createProject(Project newProject) {
      projectDao.save(newProject);
      return newProject.getId();
      
      
    }

    @Transactional
    public String updateProject(Project updatedProject) {
      projectDao.save(updatedProject);
      return updatedProject.getId();
    }

    
}
