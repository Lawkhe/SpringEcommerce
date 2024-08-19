package com.ecommerce.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.models.Product;
import com.ecommerce.ecommerce.models.User;
import com.ecommerce.ecommerce.repository.ProductRepository;
import com.ecommerce.ecommerce.repository.UserRepository;
import com.ecommerce.ecommerce.response.ProductSalesDTO;
import com.ecommerce.ecommerce.response.UserPurchaseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Product> getActiveProducts() {
        return productRepository.findActiveProducts();
    }

    public long getNumberOfActiveProducts() {
        return productRepository.countActiveProducts();
    }

    public long getNumberOfInactiveProducts() {
        return productRepository.countInactiveProducts();
    }

    public List<ProductSalesDTO> getTopSellingProducts(int topN) {
        List<ProductSalesDTO> results = productRepository.findTopSellingProducts();
        return results.stream()
                .limit(topN)
                .collect(Collectors.toList());
    }

    public List<UserPurchaseDTO> getTopFrequentUsers(int topN) {
        List<UserPurchaseDTO> results = productRepository.findTopFrequentUsers();
        return results.stream()
                .limit(topN)
                .collect(Collectors.toList());
    }
}