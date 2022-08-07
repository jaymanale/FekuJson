package com.springboot.app.fekuAPI.repository;

import com.springboot.app.fekuAPI.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
