package com.ecommerce.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.ecommerce.models.Category;
import com.ecommerce.ecommerce.models.Product;
import com.ecommerce.ecommerce.payload.ProductDTO;
import com.ecommerce.ecommerce.service.ProductService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Product createProduct(@RequestBody ProductDTO productDetails) {
        // Crear el producto
        Product product = new Product();
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setAmount(productDetails.getAmount());
        product.setImage(productDetails.getImage());
        product.setState(productDetails.getState());

        // Buscar la categoría por ID y asignarla al producto
        if (productDetails.getCategoryId() != null) {
            Category category = new Category();
            category.setId(productDetails.getCategoryId());
            product.setCategory(category);
        }
        // Guardar el producto en la base de datos
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDetails) {
        return productService.getProductById(id)
            .map(product -> {
                product.setName(productDetails.getName());
                product.setPrice(productDetails.getPrice());
                product.setAmount(productDetails.getAmount());
                product.setImage(productDetails.getImage());
                product.setState(productDetails.getState());

                System.out.println("a11111111111111111111111");
                System.out.println(productDetails.getCategoryId());
                if (productDetails.getCategoryId() != null) {
                    Category category = new Category();
                    category.setId(productDetails.getCategoryId());
                    product.setCategory(category);
                }

                Product updatedProduct = productService.updateProduct(product);
                return ResponseEntity.ok(updatedProduct);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}