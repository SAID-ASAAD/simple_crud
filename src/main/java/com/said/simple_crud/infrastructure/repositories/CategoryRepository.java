package com.said.simple_crud.infrastructure.repositories;

import com.said.simple_crud.infrastructure.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
