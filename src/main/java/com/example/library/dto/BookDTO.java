package com.example.library.dto;

import java.util.List;

import com.example.library.model.Book;
import com.example.library.model.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    @NotBlank(message = "The book title cannot be blank")
    private String title;
    @NotBlank(message = "The book description cannot be blank")
    private String author;
    @Size(max = 1000, message = "the book description cannot be greater than 1000 characters")
    private String description;
    @NotBlank
    private List<Category> categories;
    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.description = book.getDescription();
        this.categories = book.getCategories();
    }
    
}
