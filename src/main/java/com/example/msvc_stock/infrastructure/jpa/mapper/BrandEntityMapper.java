package com.example.msvc_stock.infrastructure.jpa.mapper;

import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.infrastructure.jpa.entities.BrandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandEntityMapper {
    BrandEntity toEntity(Brand brand);
    Brand toDomain(BrandEntity brandEntity);
}
