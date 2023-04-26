package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.library.exception.ObjectNotFoundException;
import com.example.library.dto.BookDTO;
import com.example.library.model.Book;
import com.example.library.model.Category;
import com.example.library.repository.BookRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    public BookDTO addBook(@Valid BookDTO bookDTO, Long id) {
        Book newBook = new Book();
        Category category = categoryService.findById(id);
        newBook.setTitle(bookDTO.getTitle());
        newBook.setAuthor(bookDTO.getAuthor());
        newBook.setDescription(bookDTO.getDescription());
        bookDTO.getCategories().add(category);
        newBook.setCategories(bookDTO.getCategories());
        bookRepository.save(newBook);
        return bookDTO;
    }

    public List<Book> findAllByCategory(Long id) {
        return bookRepository.findByCategory(categoryService.findById(id));
    }

    public Book findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found, id: " + id + ",Type:" + Book.class.getName()));
    }

    public void deleteById(Long id) {
        if ( !bookRepository.existsById(id)) {
			throw new ObjectNotFoundException("id " + id +" doesn't exist");}
                bookRepository.deleteById(id);
    }

    public Book updateById(Long id, BookDTO book) {
        book.setId(id);
        Book newBook = new Book(book.getId(), book.getTitle(), book.getAuthor(), book.getDescription(),
                book.getCategories());
        Category category = categoryService.findByBooks(newBook);
        newBook.getCategories().add(category);
        return bookRepository.save(newBook);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

}
