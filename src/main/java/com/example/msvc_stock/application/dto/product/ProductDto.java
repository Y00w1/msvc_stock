package com.example.msvc_stock.application.dto.product;

import com.example.msvc_stock.application.dto.brand.BrandDto;
import com.example.msvc_stock.application.dto.category.CategoryDto;

import java.util.Set;

public record ProductDto(
        Long id,
        String name,
        String description,
        Integer stock,
        Double price,
        Set<CategoryDto> categories,
        BrandDto brand
) {
}
