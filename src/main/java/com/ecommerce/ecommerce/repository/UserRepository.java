package com.ecommerce.ecommerce.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.ecommerce.models.User;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username); 
}
