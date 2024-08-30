package com.example.msvc_stock.domain.ports.in.brand;

import com.example.msvc_stock.domain.models.Brand;

public interface CreateBrandUseCase {
    Brand createBrand(Brand brand);
}
