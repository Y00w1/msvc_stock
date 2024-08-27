package com.example.msvc_stock.application.dto.pagination;

import jakarta.validation.constraints.Min;

public record PaginationDto(
        @Min(value = 0, message = "Page number must be greater than or equal to 0") int page,
        @Min(value = 1, message = "Page size must be greater than or equal to 1") int size
) {
    public PaginationDto() {
        this(0, 10); // Default page = 0, size = 10
    }
}
