package com.example.msvc_stock.application.dto.mapper.brand;

import com.example.msvc_stock.application.dto.brand.BrandDto;
import com.example.msvc_stock.application.dto.brand.CreateBrandDto;
import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.models.Paged;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    Brand toDomain(CreateBrandDto createBrandDto);
    Brand toDomain(BrandDto brandDto);
    BrandDto toDto(Brand brand);
    List<BrandDto> toDto(List<Brand> brands);
    @Mapping(target = "items", expression = "java(toDto(paged.getItems()))")
    @Mapping(target = "page", expression = "java(paged.getPage())")
    @Mapping(target = "totalElements", expression = "java(paged.getTotalElements())")
    @Mapping(target = "totalPages", expression = "java(paged.getTotalPages())")
    Paged<BrandDto> toDtoPaged(Paged<Brand> paged);
}
