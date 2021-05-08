package ault.BookReviews.repositories;

import ault.BookReviews.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {
  List<Project> findByProjectName(@Param("name") String name);
} 
