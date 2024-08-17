package com.ecommerce.ecommerce.models;

import lombok.Data;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buys_id", nullable = false)
    private Buys buys;
    
}
