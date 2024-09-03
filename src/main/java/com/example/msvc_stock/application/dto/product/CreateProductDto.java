package com.example.msvc_stock.application.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CreateProductDto(
        @NotBlank(message = "Name cannot be blank")
        @Size(max = 50, message = "Name cannot exceed 50 characters")
        String name,
        @NotBlank(message = "Description cannot be blank")
        @Size(max = 120, message = "Description cannot exceed 120 characters")
        String description,
        @NotNull(message = "Stock cannot be null")
        @Positive(message = "Stock must be a positive integer")
        Integer stock,
        @NotNull(message = "Price cannot be null")
        @Positive(message = "Price must be a positive number")
        Double price,
        @NotNull(message = "Categories IDs cannot be null")
        List<Long> categoriesIds,
        @NotNull(message = "Brand ID cannot be null")
        Long brandId
) {
}
