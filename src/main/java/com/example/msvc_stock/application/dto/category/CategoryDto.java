package com.example.msvc_stock.application.dto.category;

/**
 * DTO for creating a new category.
 * Contains the necessary fields for creating a category.
 *
 * @param name Name of the category.
 * @param description Description of the category.
 */
public record CategoryDto(
        String name,
        String description
) {
}
