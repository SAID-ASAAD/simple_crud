package com.said.simple_crud.services;

import com.said.simple_crud.infrastructure.entities.Category;
import com.said.simple_crud.infrastructure.entities.Product;
import com.said.simple_crud.infrastructure.repositories.ProductRepository;
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
}
