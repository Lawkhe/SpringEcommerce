package com.ecommerce.ecommerce.payload;
import lombok.Data;

@Data
public class AuditDTO {
    private String description;
    private Long userId;
}
