package com.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.ecommerce.models.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
}