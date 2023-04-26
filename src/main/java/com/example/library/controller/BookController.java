package com.example.library.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.dto.BookDTO;
import com.example.library.model.Book;
import com.example.library.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/{id}")
    public ResponseEntity<?> addBook(@RequestBody @Valid BookDTO bookDTO, @PathVariable Long id) {

        return new ResponseEntity<BookDTO>(bookService.addBook(bookDTO, id), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        List<Book> books = bookService.findAll();
        List<BookDTO> bookDTOs = books.stream().map(book -> new BookDTO(book)).collect(Collectors.toList());
        if (bookDTOs.isEmpty()) {
            return new ResponseEntity<>("No books found", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getAllBooksByCategory(@PathVariable Long id) {
        List<Book> books = bookService.findAllByCategory(id);
        List<BookDTO> bookDTOs = books.stream().map(book -> new BookDTO(book)).collect(Collectors.toList());
        if (bookDTOs.isEmpty()) {
            return new ResponseEntity<>("No books found", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        BookDTO bookDTO = new BookDTO(bookService.findById(id));
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Long id) {

        bookService.deleteById(id);
        return new ResponseEntity<>("book deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable Long id, @RequestBody BookDTO book) {
        Book newBook = bookService.updateById(id, book);
        book = new BookDTO(newBook);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchBookById(@PathVariable Long id, @RequestBody BookDTO book) {
        Book newBook = bookService.updateById(id, book);
        book = new BookDTO(newBook);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

}
