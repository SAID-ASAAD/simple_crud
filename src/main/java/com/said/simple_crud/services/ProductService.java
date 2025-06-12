package com.said.simple_crud.services;

import com.said.simple_crud.infrastructure.entities.Product;
import com.said.simple_crud.infrastructure.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product insert(Product entity){
        return repository.saveAndFlush(entity);
    }
}
