package com.ecommerce.ecommerce.models;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    private int amount;

    private String image;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<Buys> buys;
    
    private Boolean state = true;

    @JsonProperty("categoryId")
    public Long getCategoryId() {
        return category != null ? category.getId() : null;
    }
}
