package com.example.msvc_stock.infrastructure.jpa.mapper;

import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Product;
import com.example.msvc_stock.infrastructure.jpa.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BrandEntityMapper.class, CategoryEntityMapper.class})
public interface ProductEntityMapper {
    ProductEntity toEntity(Product product);
    Product toDomain(ProductEntity productEntity);
    List<Product> toDomain(List<ProductEntity> productEntityList);
    @Mapping(target = "items", expression = "java(toDomain((productEntityPaged.getContent())))")
    @Mapping(target = "page", expression = "java(productEntityPaged.getNumber())")
    @Mapping(target = "totalElements", expression = "java((int) productEntityPaged.getTotalElements())")
    @Mapping(target = "totalPages", expression = "java(productEntityPaged.getTotalPages())")
    Paged<Product> toDomainPaged(Page<ProductEntity> productEntityPaged);
}
