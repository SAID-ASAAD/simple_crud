package com.said.simple_crud.services;

import com.said.simple_crud.infrastructure.entities.Category;
import com.said.simple_crud.infrastructure.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;


    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category insert(Category entity) {
        return repository.saveAndFlush(entity);
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> entity = repository.findById(id);
        return entity.get();
    }
}
