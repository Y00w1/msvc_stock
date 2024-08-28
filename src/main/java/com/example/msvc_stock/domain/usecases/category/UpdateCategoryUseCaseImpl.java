package com.example.msvc_stock.domain.usecases.category;

import com.example.msvc_stock.domain.models.Category;
import com.example.msvc_stock.domain.ports.in.category.UpdateCategoryUseCase;
import com.example.msvc_stock.domain.ports.out.category.CategoryRepositoryPort;

import java.util.Optional;

public class UpdateCategoryUseCaseImpl implements UpdateCategoryUseCase {
    private final CategoryRepositoryPort categoryRepositoryPort;

    public UpdateCategoryUseCaseImpl(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public Optional<Category> updateCategory(Category category) {
        return categoryRepositoryPort.update(category);
    }
}