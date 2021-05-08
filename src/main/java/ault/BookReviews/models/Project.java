package ault.BookReviews.models;

import java.util.Date;
import java.util.ArrayList;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Project {

  private String id;
  
  private String projectName;

  private Date completionDateGoal;

  private ArrayList<ProjectTask> tasks;

  public Project(String projectName) {
    this.projectName = projectName;
  }

  public Project(String id, String projectName) {
    this.id = id;
    this.projectName = projectName;
  }

  public Project(String id, String projectName, Date completionDateGoal, ArrayList<ProjectTask> tasks) {
    this.id = id;
    this.projectName = projectName;
    this.completionDateGoal = completionDateGoal;
    this.tasks = tasks;
  }

  public Project(String projectName, Date completionDateGoal, ArrayList<ProjectTask> tasks) {
    this.projectName = projectName;
    this.completionDateGoal = completionDateGoal;
    this.tasks = tasks;
  }

  public Project() {

  }

}