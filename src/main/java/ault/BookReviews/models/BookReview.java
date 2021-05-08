package ault.BookReviews.models;

import java.util.ArrayList;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class BookReview {

  public String id;
  
  // The book reviewed in this review
  public String bookId;

  public BookReview(String id, String bookId) {
    this.id=id;
    this.bookId=bookId;
  }


}