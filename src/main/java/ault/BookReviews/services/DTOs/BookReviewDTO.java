package ault.BookReviews.services.DTOs;

import java.util.ArrayList;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;

import ault.BookReviews.models.Book;
import ault.BookReviews.models.BookReview;
import ault.BookReviews.repositories.BookRepository;

@Data
@Document
public class BookReviewDTO {

  private String id;
  
  // The book reviewed in this review
  private Book book;

  public BookReviewDTO(String id, Book book) {
    this.id=id;
    this.book=book;
  }


}