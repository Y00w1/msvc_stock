package com.example.msvc_stock.domain.ports.in;

import com.example.msvc_stock.domain.models.Category;

import java.util.Optional;

public interface RetrieveCategoryUseCase {
    Optional<Category> retrieveCategory(Long id);
}
