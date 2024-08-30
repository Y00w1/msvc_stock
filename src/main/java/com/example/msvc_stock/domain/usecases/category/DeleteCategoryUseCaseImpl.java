package com.example.msvc_stock.domain.usecases.category;

import com.example.msvc_stock.domain.ports.in.category.DeleteCategoryUseCase;
import com.example.msvc_stock.domain.ports.out.category.CategoryRepositoryPort;

public class DeleteCategoryUseCaseImpl implements DeleteCategoryUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;

    public DeleteCategoryUseCaseImpl(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public boolean deleteCategory(Long id) {
        return categoryRepositoryPort.deleteById(id);
    }
}
