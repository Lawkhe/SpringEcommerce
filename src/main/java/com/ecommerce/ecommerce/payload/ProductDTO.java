package com.ecommerce.ecommerce.payload;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Long price;
    private int amount;
    private String image;
    private Long categoryId;
    private Boolean state;
}
