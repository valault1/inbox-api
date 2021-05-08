package ault.BookReviews.repositories;

import ault.BookReviews.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
  List<Book> findByBookName(@Param("name") String name);
} 
