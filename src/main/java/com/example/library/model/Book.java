package com.example.library.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 50, nullable = false)
    @NotBlank(message = "The book title cannot be blank")
    private String title;
    @Column(length = 50, nullable = false)
    @NotBlank(message = "The book description cannot be blank")
    private String author;
    @Column(length = 1000)
    @Size(max = 1000,message = "the book description cannot be greater than 1000 characters")
    private String description;
    @ManyToMany
    @JoinTable(name = "BOOK_CATEGORY", joinColumns = @JoinColumn(name = "BOOK_ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    private List<Category> categories;

}
