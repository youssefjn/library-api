package com.example.library.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Book;
import com.example.library.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    
    Category findByBook(Book book);
}
