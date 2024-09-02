package com.example.msvc_stock.application.dto.mapper.product;

import com.example.msvc_stock.application.dto.product.CreateProductDto;
import com.example.msvc_stock.application.dto.product.ProductDto;
import com.example.msvc_stock.domain.models.Category;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "brand", expression = "java(new Brand(createProductDto.brandId(), null, null))")
    @Mapping(target = "categories", expression = "java(mapCategories(createProductDto.categoriesIds()))")
    Product toDomain(CreateProductDto createProductDto);
    ProductDto toDto(Product product);
    Product toDomain(ProductDto productDto);
    List<ProductDto> toDto(List<Product> products);
    @Mapping(target = "items", expression = "java(toDto(paged.getItems()))")
    @Mapping(target = "page", expression = "java(paged.getPage())")
    @Mapping(target = "totalElements", expression = "java(paged.getTotalElements())")
    @Mapping(target = "totalPages", expression = "java(paged.getTotalPages())")
    Paged<ProductDto> toDtoPaged(Paged<Product> paged);

    default List<Category> mapCategories(List<Long> categoriesIds) {
        return categoriesIds.stream()
                .map(id -> {
                    Category category = new Category();
                    category.setId(id);
                    return category;
                })
                .collect(Collectors.toList());
    }
}
