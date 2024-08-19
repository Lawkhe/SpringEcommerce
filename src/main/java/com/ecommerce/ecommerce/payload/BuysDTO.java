package com.ecommerce.ecommerce.payload;

import java.util.List;
import lombok.Data;

@Data
public class BuysDTO {
    private int amount;
    private Long total;
    private Long userId;
    private List<Long> productIds;
    private int status;
}
