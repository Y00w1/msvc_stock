package com.example.msvc_stock.application.services.category;

import com.example.msvc_stock.application.dto.category.CategoryDto;
import com.example.msvc_stock.application.dto.category.CreateCategoryDto;
import com.example.msvc_stock.application.dto.pagination.PaginationDto;
import com.example.msvc_stock.application.dto.pagination.SortDto;
import com.example.msvc_stock.domain.models.Paged;

public interface CategoryService {
    CategoryDto createCategory(CreateCategoryDto createCategoryDto);
    Paged<CategoryDto> getCategories(PaginationDto paginationDto, SortDto sortDto);
}
