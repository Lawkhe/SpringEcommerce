package com.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.ecommerce.models.Audit;

public interface AuditRepository extends JpaRepository<Audit, Long> {
}
