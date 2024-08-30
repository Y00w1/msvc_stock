package com.example.msvc_stock.domain.ports.in.category;

import com.example.msvc_stock.domain.models.Category;

import java.util.Optional;

public interface UpdateCategoryUseCase {
    Optional<Category> updateCategory(Category category);
}
