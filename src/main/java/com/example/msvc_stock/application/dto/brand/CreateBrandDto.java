package com.example.msvc_stock.application.dto.brand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateBrandDto(
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    String name,
    @NotBlank(message = "Description cannot be blank")
    @Size(max = 120, message = "Description cannot exceed 120 characters")
    String description
) {
}
