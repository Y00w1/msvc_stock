package com.example.msvc_stock.domain.usecases.category;

import com.example.msvc_stock.domain.exceptions.category.CategoryNotFoundException;
import com.example.msvc_stock.domain.models.Category;
import com.example.msvc_stock.domain.ports.in.category.GetCategoryByIdUseCase;
import com.example.msvc_stock.domain.ports.out.category.CategoryRepositoryPort;

import java.util.Optional;

public class GetCategoryByIdUseCaseImpl implements GetCategoryByIdUseCase {
    private final CategoryRepositoryPort categoryRepositoryPort;

    public GetCategoryByIdUseCaseImpl(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return Optional.ofNullable(categoryRepositoryPort.getById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id)));
    }
}
