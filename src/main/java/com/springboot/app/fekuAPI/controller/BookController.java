package com.springboot.app.fekuAPI.controller;

import com.springboot.app.fekuAPI.model.Book;
import com.springboot.app.fekuAPI.model.SingleMessage;
import com.springboot.app.fekuAPI.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required =  false) Integer pageSize
    ) {
        return new ResponseEntity<List<Book>>(bookService.getBooks(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable("id") Long id, @RequestBody Book book) {
        return new ResponseEntity<>(bookService.updateBookById(id, book), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SingleMessage> deleteBookById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookService.deleteBookById(id), HttpStatus.OK);
    }


}
