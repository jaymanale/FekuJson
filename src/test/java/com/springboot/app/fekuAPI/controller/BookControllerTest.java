package com.springboot.app.fekuAPI.controller;

import com.springboot.app.fekuAPI.data.BookData;
import com.springboot.app.fekuAPI.model.Book;
import com.springboot.app.fekuAPI.model.PostResponse;
import com.springboot.app.fekuAPI.model.SingleMessage;
import com.springboot.app.fekuAPI.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookControllerTest {

  @InjectMocks
  private BookController bookController;

  @Mock
  private BookService bookService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetBooks() {
    int pageNumber = 0;
    int pageSize = 10;
    String sortBy = "title";
    String sortDir = "asc";


    PostResponse<Book> postResponse = new PostResponse<>();
    List<Book> booksList = BookData.generateBookData(100);
    postResponse.setContent(booksList);
    Mockito.when(bookService.getBooks(pageNumber, pageSize, sortBy, sortDir)).thenReturn(postResponse);

    ResponseEntity<PostResponse<Book>> responseEntity = bookController.getBooks(pageNumber, pageSize, sortBy, sortDir);

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(postResponse, responseEntity.getBody());
  }

  @Test
  void testGetBookById() {
    Long bookId = 1L;
    Book book = new Book();
    book.setId(bookId);

    Mockito.when(bookService.getBookById(bookId)).thenReturn(book);

    ResponseEntity<Book> responseEntity = bookController.getBookById(bookId);

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(book, responseEntity.getBody());
  }

  @Test
  void testUpdateBookById() {
    Long bookId = 1L;
    Book book = new Book();
    book.setId(bookId);

    Mockito.when(bookService.updateBookById(bookId, book)).thenReturn(book);

    ResponseEntity<Book> responseEntity = bookController.updateBookById(bookId, book);

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(book, responseEntity.getBody());
  }

  @Test
  void testDeleteBookById() {
    Long bookId = 1L;
    SingleMessage singleMessage = new SingleMessage("Book with ID : 1 Deleted Successfully.");

    Mockito.when(bookService.deleteBookById(bookId)).thenReturn(singleMessage);

    ResponseEntity<SingleMessage> responseEntity = bookController.deleteBookById(bookId);

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(singleMessage, responseEntity.getBody());
  }
}
