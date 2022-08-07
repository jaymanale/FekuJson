package com.springboot.app.fekuAPI.service;

import com.springboot.app.fekuAPI.model.Book;
import com.springboot.app.fekuAPI.model.SingleMessage;

import java.util.List;

public interface BookService {
    void deleteAllBookSchedulerJob();

    void generateNewBookDataScheduler(List<Book> booksList);

    List<Book> getBooks();

    Book getBookById(Long id);

    Book updateBookById(Long id, Book book);

    SingleMessage deleteBookById(Long id);
}
