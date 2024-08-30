package com.example.msvc_stock.infrastructure.controllers;

import com.example.msvc_stock.application.dto.brand.BrandDto;
import com.example.msvc_stock.application.dto.brand.CreateBrandDto;
import com.example.msvc_stock.application.services.brand.BrandService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing brand-related operations.
 * <p>
 * This controller handles the HTTP requests related to brands.
 */
@RestController
@RequestMapping("/brand")
@AllArgsConstructor
public class BrandController {
    private final BrandService brandService;

    /**
     * Creates a new brand.
     * <p>
     * This endpoint accepts a POST request with a {@link CreateBrandDto} object in the request body,
     * validates it, and creates a new brand based on the provided data.
     *
     * @param createBrandDto The {@link CreateBrandDto} object containing the brand details to be created.
     * @return A {@link ResponseEntity} containing the created {@link BrandDto} object and the HTTP status code {@code 201 CREATED}.
     */
    @PostMapping("/create")
    public ResponseEntity<BrandDto> createBrand(@Valid @RequestBody CreateBrandDto createBrandDto) {
        return new ResponseEntity<>(brandService.create(createBrandDto), HttpStatus.CREATED);
    }
}
