package com.ecommerce.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.ecommerce.models.Buys;
import com.ecommerce.ecommerce.payload.BuysDTO;
import com.ecommerce.ecommerce.service.BuysService;

import java.util.List;

@RestController
@RequestMapping("/api/buys")
public class BuysController {

    @Autowired
    private BuysService buysService;

    @GetMapping
    public List<Buys> getAllBuys() {
        return buysService.getAllBuys();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Buys>> getBuysByUserId(@PathVariable Long userId) {
        List<Buys> buys = buysService.getBuysByUserId(userId);
        if (buys.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(buys);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buys> getBuysById(@PathVariable Long id) {
        return buysService.getBuysById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<Buys> createBuys(@RequestBody BuysDTO buysDTO) {
        Buys createdBuys = buysService.createBuys(buysDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBuys);
    }
}
