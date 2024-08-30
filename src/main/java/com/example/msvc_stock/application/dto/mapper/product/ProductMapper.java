package com.example.msvc_stock.application.dto.mapper.product;

import com.example.msvc_stock.application.dto.product.CreateProductDto;
import com.example.msvc_stock.application.dto.product.ProductDto;
import com.example.msvc_stock.domain.models.Category;
import com.example.msvc_stock.domain.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "brand", expression = "java(new Brand(createProductDto.brandId(), null, null))")
    @Mapping(target = "categories", expression = "java(mapCategories(createProductDto.categoriesIds()))")
    Product toDomain(CreateProductDto createProductDto);
    ProductDto toDto(Product product);
    Product toDomain(ProductDto productDto);

    default Set<Category> mapCategories(Set<Long> categoriesIds) {
        return categoriesIds.stream()
                .map(id -> {
                    Category category = new Category();
                    category.setId(id);
                    return category;
                })
                .collect(Collectors.toSet());
    }
}
