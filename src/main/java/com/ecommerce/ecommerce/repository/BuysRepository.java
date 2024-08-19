package com.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.models.Buys;
import java.util.List;

@Repository
public interface BuysRepository extends JpaRepository<Buys, Long> {
    List<Buys> findByUserId(Long userId);
}
