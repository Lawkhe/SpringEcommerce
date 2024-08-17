package com.ecommerce.ecommerce.models;

import lombok.Data;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Buys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int amount;

    private Long total;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(
        name = "buys_products",
        joinColumns = @JoinColumn(name = "buys_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    
    private int status = 1;
}
