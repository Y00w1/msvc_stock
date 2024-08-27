package com.example.msvc_stock.application.dto.pagination;

import com.example.msvc_stock.infrastructure.util.enums.SorterDirection;
import jakarta.validation.constraints.NotBlank;

public record SortDto(
        @NotBlank(message = "Sort field cannot be empty") String field,
        SorterDirection direction
) {
    public SortDto() {
        this("name", SorterDirection.ASC); // Default sort by 'name' in ascending order
    }
}
