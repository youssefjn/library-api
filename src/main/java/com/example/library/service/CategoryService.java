package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.library.dto.CategoryDTO;
import com.example.library.exception.ObjectNotFoundException;
import com.example.library.model.Book;
import com.example.library.model.Category;
import com.example.library.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Type: " + CategoryService.class.getName()));
    }

    public Category findByBooks(Book newBook) {
        return categoryRepository.findByBook(newBook);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category updateAll(CategoryDTO objDto) {
        Category newObj = new Category(objDto.getId(), objDto.getName());
		return categoryRepository.save(newObj);    
    }

    public CategoryDTO create(CategoryDTO objDTO) {
        Category newObj = new Category(null, objDTO.getName());
        categoryRepository.save(newObj);
        return fromDTO(newObj);
    }
    
    public void deleteById(Long id) {
        if ( !categoryRepository.existsById(id)) {
			throw new ObjectNotFoundException("id " + id +" doesn't exist");
        }
            categoryRepository.deleteById(id);
    }
    
    public CategoryDTO fromDTO(Category category) {
        return new CategoryDTO(category);
    }

}
