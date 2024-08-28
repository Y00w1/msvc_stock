package com.example.msvc_stock.domain.ports.out.brand;

import com.example.msvc_stock.domain.models.Brand;

import java.util.Optional;

public interface BrandRepositoryPort {
    Optional<Brand> getByName(String name);
    Brand createBrand(Brand brand);
}
