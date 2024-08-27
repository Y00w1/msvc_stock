package com.example.msvc_stock.infrastructure.jpa.mapper;

import com.example.msvc_stock.domain.models.Category;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.infrastructure.jpa.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {
    CategoryEntity toEntity(Category category);
    Category toModel(CategoryEntity categoryEntity);
    List<Category> toModel(List<CategoryEntity> categoryEntityList);
    @Mapping(target = "items", expression = "java(toModel((categoryEntityPaged.getContent())))")
    @Mapping(target = "page", expression = "java(categoryEntityPaged.getNumber())")
    @Mapping(target = "size", expression = "java((int) categoryEntityPaged.getTotalElements())")
    @Mapping(target = "total", expression = "java(categoryEntityPaged.getTotalPages())")
    Paged<Category> toModelPaged(Page<CategoryEntity> categoryEntityPaged);
}
