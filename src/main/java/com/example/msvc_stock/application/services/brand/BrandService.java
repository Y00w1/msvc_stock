package com.example.msvc_stock.application.services.brand;

import com.example.msvc_stock.application.dto.brand.BrandDto;
import com.example.msvc_stock.application.dto.brand.CreateBrandDto;

public interface BrandService {
    BrandDto create(CreateBrandDto createBrandDto);
}
