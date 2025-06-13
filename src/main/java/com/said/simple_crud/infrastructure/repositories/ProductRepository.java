package com.said.simple_crud.infrastructure.repositories;

import com.said.simple_crud.infrastructure.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
