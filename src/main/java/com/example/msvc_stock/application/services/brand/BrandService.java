package com.example.msvc_stock.application.services.brand;

import com.example.msvc_stock.application.dto.brand.BrandDto;
import com.example.msvc_stock.application.dto.brand.CreateBrandDto;
import com.example.msvc_stock.application.dto.pagination.PaginationDto;
import com.example.msvc_stock.application.dto.pagination.SortDto;
import com.example.msvc_stock.domain.models.Paged;

public interface BrandService {
    BrandDto create(CreateBrandDto createBrandDto);
    Paged<BrandDto> getBrands(PaginationDto paginationDto, SortDto sortDto);
}
