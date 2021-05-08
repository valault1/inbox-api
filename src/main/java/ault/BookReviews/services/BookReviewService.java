package ault.BookReviews.services;

import ault.BookReviews.repositories.*;
import ault.BookReviews.services.DTOs.BookReviewDTO;
import ault.BookReviews.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookReviewService {
    private final BookReviewRepository _bookReviewRepository;
    private final BookRepository _bookRepository;

    @Autowired
    public BookReviewService(BookReviewRepository bookReviewRepository, BookRepository bookRepository) {
        this._bookReviewRepository = bookReviewRepository;
        this._bookRepository = bookRepository;
    }

    @Transactional
    public BookReviewDTO bookReview(String id) {
      return getBookReviewDTO(_bookReviewRepository.findById(id).get());
    }

    @Transactional
    public List<BookReviewDTO> bookReviews() {
      return getBookReviewDTOs(_bookReviewRepository.findAll());
    }

    @Transactional
    public long projectCount() {
      return _bookReviewRepository.count();
    }

    @Transactional
    public String createBookReview(BookReview newBookReview) {
      _bookReviewRepository.save(newBookReview);
      return newBookReview.getId();
      
      
    }

    @Transactional
    public String updateBookReview(BookReview updatedBookReview) {
      _bookReviewRepository.save(updatedBookReview);
      return updatedBookReview.getId();
    }

    public BookReviewDTO getBookReviewDTO(BookReview br) {
      return new BookReviewDTO(br.id, _bookRepository.findById(br.bookId).get());
    }
    public List<BookReviewDTO> getBookReviewDTOs(List<BookReview> brs) {
      List<BookReviewDTO> result = new ArrayList<BookReviewDTO>();
      for (BookReview br : brs) {
        result.add(getBookReviewDTO(br));
      }
      return result;
    }

    
}
