package ault.BookReviews.models;

import java.util.ArrayList;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Book {

  private String id;
  
  private String bookName;

  private ArrayList<String> tags;

  public Book(String bookName) {
    this.bookName = bookName;
  }

  public Book(String id, String bookName) {
    this.id = id;
    this.bookName = bookName;
  }

  public Book(String id, String bookName, ArrayList<String> tags) {
    this.id = id;
    this.bookName = bookName;
    this.tags = tags;
  }


  public Book(String bookName, ArrayList<String> tags) {
    this.bookName = bookName;
    this.tags = tags;
  }

  public Book() {

  }

}