package com.example.msvc_stock.application.dto.mapper;

import com.example.msvc_stock.application.dto.category.CategoryDto;
import com.example.msvc_stock.application.dto.category.CreateCategoryDto;
import com.example.msvc_stock.domain.models.Category;
import com.example.msvc_stock.domain.models.Paged;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toDomain(CreateCategoryDto createCategoryDto);
    CategoryDto toDto(Category category);
    List<CategoryDto> toDto(List<Category> categories);
    @Mapping(target = "items", expression = "java(toDto(paged.getItems()))")
    @Mapping(target = "page", expression = "java(paged.getPage())")
    @Mapping(target = "size", expression = "java(paged.getSize())")
    @Mapping(target = "total", expression = "java(paged.getTotal())")
    Paged<CategoryDto> toDtoPaged(Paged<Category> paged);
}
