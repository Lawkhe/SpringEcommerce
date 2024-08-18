package com.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.ecommerce.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Métodos
}
