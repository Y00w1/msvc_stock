package com.example.msvc_stock.domain.ports.in.category;

import com.example.msvc_stock.domain.models.Category;

import java.util.Optional;

public interface GetCategoryByIdUseCase {
    Optional<Category> getCategoryById(Long id);
}
