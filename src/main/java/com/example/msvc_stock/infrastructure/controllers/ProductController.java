package com.example.msvc_stock.infrastructure.controllers;

import com.example.msvc_stock.application.dto.product.CreateProductDto;
import com.example.msvc_stock.application.dto.product.ProductDto;
import com.example.msvc_stock.application.services.product.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * REST controller to handle operations related to products.
 * Maps HTTP requests to appropriate service methods.
 */
@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    /**
     * Endpoint to create a new product.
     *
     * @param productDto Object containing the data for the product to be created.
     * @return ResponseEntity with the DTO of the created product.
     */
    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody CreateProductDto productDto){
        return ResponseEntity.ok(productService.createProduct(productDto));
    }
}
