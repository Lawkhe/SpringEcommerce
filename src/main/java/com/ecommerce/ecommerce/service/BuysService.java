package com.ecommerce.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.models.Buys;
import com.ecommerce.ecommerce.models.Product;
import com.ecommerce.ecommerce.models.User;
import com.ecommerce.ecommerce.payload.BuysDTO;
import com.ecommerce.ecommerce.repository.BuysRepository;
import com.ecommerce.ecommerce.repository.ProductRepository;
import com.ecommerce.ecommerce.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.sql.Timestamp;
import java.time.Instant;

@Service
public class BuysService {

    @Autowired
    private BuysRepository buysRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Buys> getBuysByUserId(Long userId) {
        return buysRepository.findByUserId(userId);
    }

    public List<Buys> getAllBuys() {
        return buysRepository.findAll();
    }

    public Optional<Buys> getBuysById(Long id) {
        return buysRepository.findById(id);
    }

    public Buys createBuys(BuysDTO buysDTO) {
        User user = userRepository.findById(buysDTO.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));

        List<Product> products = productRepository.findAllById(buysDTO.getProductIds());

        Buys buys = new Buys();
        buys.setAmount(buysDTO.getAmount());
        buys.setTotal(buysDTO.getTotal());
        buys.setUser(user);
        buys.setProducts(products);
        buys.setStatus(buysDTO.getStatus());
        // Genera automáticamente la fecha y hora actual
        buys.setCreateDate(Timestamp.from(Instant.now()));

        return buysRepository.save(buys);
    }
}
