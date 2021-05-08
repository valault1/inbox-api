package ault.BookReviews.services.DTOs;

import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;

import ault.BookReviews.models.Book;

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