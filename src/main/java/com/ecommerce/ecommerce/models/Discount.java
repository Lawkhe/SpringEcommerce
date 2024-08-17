package com.ecommerce.ecommerce.models;

import lombok.Data;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int percentage;

    @Temporal(TemporalType.DATE)
    private Date initDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    private Boolean state = true;
}
