package com.springboot.app.fekuAPI.service;

import com.springboot.app.fekuAPI.exception.ResourceNotFoundException;
import com.springboot.app.fekuAPI.model.Book;
import com.springboot.app.fekuAPI.model.PostResponse;
import com.springboot.app.fekuAPI.model.SingleMessage;
import com.springboot.app.fekuAPI.repository.BookRepository;
import com.springboot.app.fekuAPI.util.UtilHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    // Scheduler Functions
    @Override
    public void deleteAllBookSchedulerJob() {
        bookRepository.deleteAll();
    }

    @Override
    public void generateNewBookDataScheduler(List<Book> booksList) {
        bookRepository.saveAll(booksList);
    }

    @Override
    public PostResponse<Book> getBooks(Integer pageNumber, Integer pageSize) {

        Pageable pageObject = PageRequest.of(pageNumber, pageSize);
        Page<Book> pageableBook = bookRepository.findAll(pageObject);
        return UtilHelper.preparePostResponse(pageableBook);

    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book is not found with id : '" + id + "'"));
    }

    @Override
    public Book updateBookById(Long id, Book book) {
        Book existingBook = getBookById(id);

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setGenre(book.getGenre());
        existingBook.setPublisher(book.getPublisher());

        bookRepository.save(existingBook);
        return existingBook;

    }

    @Override
    public SingleMessage deleteBookById(Long id) {
        getBookById(id);
        bookRepository.deleteById(id);
        return new SingleMessage("Book with ID : " + id + " Deleted Successfully.");

    }
}
