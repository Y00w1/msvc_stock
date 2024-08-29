package com.example.msvc_stock.domain.ports.out.category;

import com.example.msvc_stock.domain.models.Category;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Pagination;
import com.example.msvc_stock.domain.models.Sorter;

import java.util.Optional;

public interface CategoryRepositoryPort {
    Category save(Category category);
    Optional<Category> findById(Long id);
    Optional<Category> findByName(String name);
    Paged<Category> findAll(Pagination pagination, Sorter sorter);
    Optional<Category> update(Category category);
    boolean deleteById(Long id);
}
