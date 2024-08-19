package com.ecommerce.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.models.Product;
import com.ecommerce.ecommerce.models.User;
import com.ecommerce.ecommerce.response.ProductCountsDTO;
import com.ecommerce.ecommerce.response.ProductSalesDTO;
import com.ecommerce.ecommerce.response.UserPurchaseDTO;
import com.ecommerce.ecommerce.service.DashboardService;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/active-products")
    public List<Product> getActiveProducts() {
        return dashboardService.getActiveProducts();
    }

    @GetMapping("/product-counts")
    public ProductCountsDTO getProductCounts() {
        long activeCount = dashboardService.getNumberOfActiveProducts();
        long inactiveCount = dashboardService.getNumberOfInactiveProducts();
        return new ProductCountsDTO(activeCount, inactiveCount);
    }

    @GetMapping("/top-selling-products")
    public List<ProductSalesDTO> getTopSellingProducts(@RequestParam(defaultValue = "5") int topN) {
        return dashboardService.getTopSellingProducts(topN);
    }

    @GetMapping("/top-frequent-users")
    public List<UserPurchaseDTO> getTopFrequentUsers(@RequestParam(defaultValue = "5") int topN) {
        return dashboardService.getTopFrequentUsers(topN);
    }
}
