package com.springboot.app.fekuAPI.service;

import com.springboot.app.fekuAPI.exception.ResourceNotFoundException;
import com.springboot.app.fekuAPI.model.Book;
import com.springboot.app.fekuAPI.model.PostResponse;
import com.springboot.app.fekuAPI.model.SingleMessage;
import com.springboot.app.fekuAPI.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookServiceImplTest {

  @InjectMocks
  private BookServiceImpl bookService;

  @Mock
  private BookRepository bookRepository;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testDeleteAllBookSchedulerJob() {
    bookService.deleteAllBookSchedulerJob();
    Mockito.verify(bookRepository, Mockito.times(1)).deleteAll();
  }

  @Test
  void testGenerateNewBookDataScheduler() {
    List<Book> booksList = new ArrayList<>();
    // Add some books to the list

    bookService.generateNewBookDataScheduler(booksList);
    Mockito.verify(bookRepository, Mockito.times(1)).saveAll(booksList);
  }

  @Test
  void testGetBooks() {
    int pageNumber = 0;
    int pageSize = 10;
    String sortBy = "title";
    String sortDir = "asc";

    Sort sort = Sort.by(Sort.Direction.ASC, "title");
    PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);

    List<Book> books = new ArrayList<>(); // Add some books to the list
    Page<Book> bookPage = new PageImpl<>(books);

    Mockito.when(bookRepository.findAll(pageRequest)).thenReturn(bookPage);

    PostResponse<Book> result = bookService.getBooks(pageNumber, pageSize, sortBy, sortDir);

    assertEquals(books, result.getContent());
  }

  @Test
  void testGetBookById() {
    Long bookId = 1L;
    Book book = new Book();
    book.setId(bookId);

    Mockito.when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

    Book result = bookService.getBookById(bookId);

    assertEquals(book, result);
  }

  @Test
  void testGetBookByIdNotFound() {
    Long bookId = 1L;
    Mockito.when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

    assertThrows(ResourceNotFoundException.class, () -> bookService.getBookById(bookId));
  }

  @Test
  void testUpdateBookById() {
    Long bookId = 1L;
    Book existingBook = new Book();
    existingBook.setId(bookId);

    Book updatedBook = new Book();
    updatedBook.setId(bookId);
    updatedBook.setTitle("Updated Title");

    Mockito.when(bookRepository.findById(bookId)).thenReturn(Optional.of(existingBook));
    Mockito.when(bookRepository.save(existingBook)).thenReturn(updatedBook);

    Book result = bookService.updateBookById(bookId, updatedBook);

    assertEquals(updatedBook, result);
    assertEquals("Updated Title", result.getTitle());
  }

  @Test
  void testDeleteBookById() {
    Long bookId = 1L;
    Book book = new Book();
    book.setId(bookId);

    Mockito.when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

    SingleMessage result = bookService.deleteBookById(bookId);

    assertEquals("Book with ID : 1 Deleted Successfully.", result.getMessage());
  }

  @Test
  void testDeleteBookByIdNotFound() {
    Long bookId = 1L;
    Mockito.when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

    assertThrows(ResourceNotFoundException.class, () -> bookService.deleteBookById(bookId));
  }
}
