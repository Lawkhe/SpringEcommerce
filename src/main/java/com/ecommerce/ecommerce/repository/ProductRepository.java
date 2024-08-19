package com.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.models.Product;
import com.ecommerce.ecommerce.response.ProductSalesDTO;
import com.ecommerce.ecommerce.response.UserPurchaseDTO;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    @Query("SELECT p FROM Product p WHERE p.state = true")
    List<Product> findActiveProducts();

    @Query("SELECT COUNT(p) FROM Product p WHERE p.state = true")
    long countActiveProducts();

    @Query("SELECT COUNT(p) FROM Product p WHERE p.state = false")
    long countInactiveProducts();
    
    @Query("SELECT new com.ecommerce.ecommerce.response.ProductSalesDTO(p, COUNT(b)) " +
           "FROM Product p JOIN p.buys b GROUP BY p ORDER BY SUM(b.amount) DESC")
    List<ProductSalesDTO> findTopSellingProducts();

    @Query("SELECT new com.ecommerce.ecommerce.response.UserPurchaseDTO(u, COUNT(b)) " +
           "FROM User u JOIN u.buys b GROUP BY u ORDER BY COUNT(b) DESC")
    List<UserPurchaseDTO> findTopFrequentUsers();

}