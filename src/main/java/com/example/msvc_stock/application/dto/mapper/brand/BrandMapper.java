package com.example.msvc_stock.application.dto.mapper.brand;

import com.example.msvc_stock.application.dto.brand.BrandDto;
import com.example.msvc_stock.application.dto.brand.CreateBrandDto;
import com.example.msvc_stock.domain.models.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    Brand toDomain(CreateBrandDto createBrandDto);
    Brand toDomain(BrandDto brandDto);
    BrandDto toDto(Brand brand);
}
