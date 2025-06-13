package com.said.simple_crud.infrastructure.repositories;

import com.said.simple_crud.infrastructure.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
