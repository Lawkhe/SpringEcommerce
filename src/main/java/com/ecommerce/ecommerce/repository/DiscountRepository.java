package com.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ecommerce.ecommerce.models.Discount;
import java.util.List;
import java.util.Date;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    @Query("SELECT d FROM Discount d WHERE :date BETWEEN d.initDate AND d.endDate")
    List<Discount> findDiscountsForDate(@Param("date") Date date);
}