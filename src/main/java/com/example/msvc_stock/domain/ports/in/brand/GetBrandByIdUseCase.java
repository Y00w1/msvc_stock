package com.example.msvc_stock.domain.ports.in.brand;

import com.example.msvc_stock.domain.models.Brand;

import java.util.Optional;

public interface GetBrandByIdUseCase {
    Optional<Brand> getBrandById(Long id);
}
