package com.example.msvc_stock.infrastructure.jpa.mapper;

import com.example.msvc_stock.domain.models.Product;
import com.example.msvc_stock.infrastructure.jpa.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {BrandEntityMapper.class, CategoryEntityMapper.class})
public interface ProductEntityMapper {
    ProductEntity toEntity(Product product);
    Product toDomain(ProductEntity productEntity);
}
