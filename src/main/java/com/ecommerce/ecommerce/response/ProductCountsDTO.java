package com.ecommerce.ecommerce.response;
import lombok.Data;

@Data
public class ProductCountsDTO {
    private long activeProducts;
    private long inactiveProducts;

    public ProductCountsDTO(long activeProducts, long inactiveProducts) {
        this.activeProducts = activeProducts;
        this.inactiveProducts = inactiveProducts;
    }
}
