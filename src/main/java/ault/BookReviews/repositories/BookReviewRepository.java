package ault.BookReviews.repositories;

import ault.BookReviews.models.BookReview;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookReviewRepository extends MongoRepository<BookReview, String> {
  
} 
