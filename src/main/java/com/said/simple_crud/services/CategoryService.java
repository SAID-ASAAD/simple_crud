package com.said.simple_crud.services;

import com.said.simple_crud.infrastructure.entities.Category;
import com.said.simple_crud.infrastructure.repositories.CategoryRepository;
import com.said.simple_crud.services.exceptions.DatabaseException;
import com.said.simple_crud.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Category update(Long id, Category obj) {
        try {
            Category entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
        }

    private void updateData(Category entity, Category obj) {
        entity.setName(obj.getName());
    }

    public void deleteById(Long id) {
        try {
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            }
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
