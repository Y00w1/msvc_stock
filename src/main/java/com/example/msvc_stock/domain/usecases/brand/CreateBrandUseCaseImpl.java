package com.example.msvc_stock.domain.usecases.brand;

import com.example.msvc_stock.domain.exceptions.brand.BrandAlreadyExistsException;
import com.example.msvc_stock.domain.exceptions.brand.BrandDescriptionTooLongException;
import com.example.msvc_stock.domain.exceptions.brand.BrandNameTooLongException;
import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.ports.in.brand.CreateBrandUseCase;
import com.example.msvc_stock.domain.ports.out.brand.BrandRepositoryPort;

public class CreateBrandUseCaseImpl implements CreateBrandUseCase {
    private final BrandRepositoryPort brandRepositoryPort;

    public CreateBrandUseCaseImpl(BrandRepositoryPort brandRepositoryPort) {
        this.brandRepositoryPort = brandRepositoryPort;
    }

    @Override
    public Brand createBrand(Brand brand) {
        validateBrand(brand);
        return brandRepositoryPort.createBrand(brand);
    }

    private void validateBrand(Brand brand) {
        if (brandRepositoryPort.getByName(brand.getName()).isPresent()) {
            throw new BrandAlreadyExistsException(brand.getName());
        }
        if (brand.getName().length() > 50) {
            throw new BrandNameTooLongException(brand.getName());
        }
        if (brand.getDescription().length() > 120) {
            throw new BrandDescriptionTooLongException(brand.getDescription());
        }
    }
}
