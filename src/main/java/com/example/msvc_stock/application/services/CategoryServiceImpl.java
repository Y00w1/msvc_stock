package com.example.msvc_stock.application.services;

import com.example.msvc_stock.application.dto.category.CategoryDto;
import com.example.msvc_stock.application.dto.category.CreateCategoryDto;
import com.example.msvc_stock.application.dto.mapper.CategoryMapper;
import com.example.msvc_stock.application.dto.mapper.PaginationMapper;
import com.example.msvc_stock.application.dto.mapper.SortMapper;
import com.example.msvc_stock.application.dto.pagination.PaginationDto;
import com.example.msvc_stock.application.dto.pagination.SortDto;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.ports.in.CreateCategoryUseCase;
import com.example.msvc_stock.domain.ports.in.GetCategoriesUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CreateCategoryUseCase createCategoryUseCase;
    private final GetCategoriesUseCase getCategoriesUseCase;
    private final CategoryMapper mapper;
    private final SortMapper sortMapper;
    private final PaginationMapper paginationMapper;


    @Override
    public CategoryDto createCategory(CreateCategoryDto createCategoryDto) {
        return mapper.toDto(createCategoryUseCase.createCategory(mapper.toDomain(createCategoryDto)));
    }

    @Override
    public Paged<CategoryDto> getCategories(PaginationDto paginationDto, SortDto sortDto) {
        return mapper.toDtoPaged(getCategoriesUseCase.getCategories(
                paginationMapper.toDomain(paginationDto),
                sortMapper.toDomain(sortDto)
        ));
    }
}
