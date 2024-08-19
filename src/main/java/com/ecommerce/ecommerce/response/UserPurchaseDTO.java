package com.ecommerce.ecommerce.response;

import com.ecommerce.ecommerce.models.User;
import lombok.Data;

@Data
public class UserPurchaseDTO {
    private User user;
    private long totalPurchases;

    public UserPurchaseDTO(User user, long totalPurchases) {
        this.user = user;
        this.totalPurchases = totalPurchases;
    }
}
