package com.example.msvc_stock.domain.usecases.brand;

import com.example.msvc_stock.domain.exceptions.brand.BrandNotFoundException;
import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.ports.in.brand.GetBrandByIdUseCase;
import com.example.msvc_stock.domain.ports.out.brand.BrandRepositoryPort;

import java.util.Optional;

public class GetBrandByIdUseCaseImpl implements GetBrandByIdUseCase {
    private final BrandRepositoryPort brandRepositoryPort;

    public GetBrandByIdUseCaseImpl(BrandRepositoryPort brandRepositoryPort) {
        this.brandRepositoryPort = brandRepositoryPort;
    }

    @Override
    public Optional<Brand> getBrandById(Long id) {
        return Optional.ofNullable(brandRepositoryPort.getById(id)
                .orElseThrow(() -> new BrandNotFoundException(id)));
    }
}
