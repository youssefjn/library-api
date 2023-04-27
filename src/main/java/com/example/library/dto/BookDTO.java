package com.example.library.dto;

import com.example.library.model.Book;
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
    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.description = book.getDescription();

    }
    
}
