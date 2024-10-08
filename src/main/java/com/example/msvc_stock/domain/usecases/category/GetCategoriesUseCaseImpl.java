package com.example.msvc_stock.domain.usecases.category;

import com.example.msvc_stock.domain.models.Category;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Pagination;
import com.example.msvc_stock.domain.models.Sorter;
import com.example.msvc_stock.domain.ports.in.category.GetCategoriesUseCase;
import com.example.msvc_stock.domain.ports.out.category.CategoryRepositoryPort;

public class GetCategoriesUseCaseImpl implements GetCategoriesUseCase {
    private final CategoryRepositoryPort categoryRepositoryPort;

    public GetCategoriesUseCaseImpl(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public Paged<Category> getCategories(Pagination pagination, Sorter sorter) {
        return categoryRepositoryPort.findAll(pagination, sorter);
    }
}
