package ault.BookReviews.DataInitialization;

import ault.BookReviews.repositories.*;
import ault.BookReviews.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

@Service
public class DataFillerService {
    private final ProjectRepository _projectRepository;
    private final BookRepository _bookRepository;
    private final BookReviewRepository _bookReviewRepository;

    @Autowired
    public DataFillerService(ProjectRepository projectRepository, BookRepository bookRepository, BookReviewRepository bookReviewRepository) {
        this._projectRepository = projectRepository;
        this._bookRepository = bookRepository;
        this._bookReviewRepository = bookReviewRepository;
    }

    @PostConstruct
    @Transactional
    public void fillData(){
        fillProjects();
        fillBooks();
        fillBookReviews();
        System.out.println("Filled data!");
        
    }

    private void fillProjects() {
        ProjectTask task1 = new ProjectTask("Work out on Tuesday");
        String projectId = "609576a2018e164aa8e9de04";
        ArrayList<ProjectTask> tasksList = new ArrayList<ProjectTask>();
        tasksList.add(task1);
        Project proj = new Project(projectId, "Project 2", new Date(),tasksList);
        _projectRepository.save(proj);
        
    }

    private void fillBooks() {
      ArrayList<String> tags = new ArrayList<String>();
      String bookId = "6095782d018e164aa8e9de1b";
      tags.add("Productivity");
      tags.add("Wisdom");
      Book book1 = new Book(bookId, "7 Habits", tags );
      _bookRepository.save(book1);
    }

    private void fillBookReviews() {
      String id = "6095782d018e164aa8e9de1c";
      String bookId = "6095782d018e164aa8e9de1b";
      BookReview br = new BookReview(id, bookId);
      _bookReviewRepository.save(br);
    }
}
