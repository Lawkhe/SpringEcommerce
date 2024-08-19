package com.ecommerce.ecommerce.response;

import com.ecommerce.ecommerce.models.Product;
import lombok.Data;

@Data
public class ProductSalesDTO {
    private Product product;
    private long totalSold;

    public ProductSalesDTO(Product product, long totalSold) {
        this.product = product;
        this.totalSold = totalSold;
    }
}
