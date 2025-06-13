package com.said.simple_crud.services;

import com.said.simple_crud.infrastructure.entities.Product;
import com.said.simple_crud.infrastructure.repositories.ProductRepository;
import com.said.simple_crud.services.exceptions.DatabaseException;
import com.said.simple_crud.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product insert(Product entity){
        return repository.saveAndFlush(entity);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> entity = repository.findById(id);
        return entity.get();
    }

    public Product update(Long id, Product obj) {
        try {
            Product entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product entity, Product obj) {
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
