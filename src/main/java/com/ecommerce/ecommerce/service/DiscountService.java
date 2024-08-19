package com.ecommerce.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.models.Discount;
import com.ecommerce.ecommerce.repository.DiscountRepository;

import java.util.List;
import java.util.Date;
import java.util.Optional;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    public Optional<Discount> getDiscountById(Long id) {
        return discountRepository.findById(id);
    }

    public List<Discount> getDiscountsForDate(Date date) {
        return discountRepository.findDiscountsForDate(date);
    }

    public Discount createDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    public Discount updateDiscount(Long id, Discount discountDetails) {
        return discountRepository.findById(id)
                .map(discount -> {
                    discount.setPercentage(discountDetails.getPercentage());
                    discount.setInitDate(discountDetails.getInitDate());
                    discount.setEndDate(discountDetails.getEndDate());
                    discount.setState(discountDetails.getState());
                    return discountRepository.save(discount);
                }).orElseThrow(() -> new RuntimeException("Discount not found"));
    }

    public void deleteDiscount(Long id) {
        discountRepository.deleteById(id);
    }
}
