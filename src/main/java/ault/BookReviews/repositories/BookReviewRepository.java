package ault.BookReviews.repositories;

import ault.BookReviews.models.BookReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookReviewRepository extends MongoRepository<BookReview, String> {
  
} 
