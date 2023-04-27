package com.example.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Book;
import com.example.library.model.Category;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByCategories(Category category);
}
