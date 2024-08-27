package com.example.msvc_stock.domain.usecases;

import com.example.msvc_stock.domain.ports.in.DeleteCategoryUseCase;
import com.example.msvc_stock.domain.ports.out.CategoryRepositoryPort;

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
