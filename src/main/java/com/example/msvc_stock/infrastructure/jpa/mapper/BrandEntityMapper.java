package com.example.msvc_stock.infrastructure.jpa.mapper;

import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.infrastructure.jpa.entities.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandEntityMapper {
    BrandEntity toEntity(Brand brand);
    Brand toDomain(BrandEntity brandEntity);
    List<Brand> toDomain(List<BrandEntity> brandEntityList);
    @Mapping(target = "items", expression = "java(toDomain((brandEntityPaged.getContent())))")
    @Mapping(target = "page", expression = "java(brandEntityPaged.getNumber())")
    @Mapping(target = "totalElements", expression = "java((int) brandEntityPaged.getTotalElements())")
    @Mapping(target = "totalPages", expression = "java(brandEntityPaged.getTotalPages())")
    Paged<Brand> toDomainPaged(Page<BrandEntity> brandEntityPaged);
}
