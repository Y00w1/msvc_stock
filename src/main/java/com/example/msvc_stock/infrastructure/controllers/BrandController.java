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

@RestController
@RequestMapping("/brand")
@AllArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping("/create")
    public ResponseEntity<BrandDto> createBrand(@Valid @RequestBody CreateBrandDto createBrandDto) {
        return new ResponseEntity<>(brandService.create(createBrandDto), HttpStatus.CREATED);
    }
}
