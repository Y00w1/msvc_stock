package com.example.msvc_stock.domain.usecases.brand;

import com.example.msvc_stock.domain.exceptions.brand.BrandAlreadyExistsException;
import com.example.msvc_stock.domain.exceptions.brand.BrandDescriptionTooLongException;
import com.example.msvc_stock.domain.exceptions.brand.BrandNameTooLongException;
import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.ports.in.brand.CreateBrandUseCase;
import com.example.msvc_stock.domain.ports.out.brand.BrandRepositoryPort;

/**
 * Implementation of the use case for creating brands.
 * Contains the business logic for validating and creating a brand.
 */
public class CreateBrandUseCaseImpl implements CreateBrandUseCase {
    private final BrandRepositoryPort brandRepositoryPort;

    /**
     * Implementation of the use case for creating brands.
     * Contains the business logic for validating and creating a brand.
     */
    public CreateBrandUseCaseImpl(BrandRepositoryPort brandRepositoryPort) {
        this.brandRepositoryPort = brandRepositoryPort;
    }

    /**
     * Creates a new brand after validating the provided data.
     *
     * @param brand Domain object representing the brand to be created.
     * @return The created brand.
     * @throws BrandAlreadyExistsException If the brand name already exists.
     * @throws BrandNameTooLongException If the brand name exceeds 50 characters.
     * @throws BrandDescriptionTooLongException If the brand description exceeds 120 characters.
     */
    @Override
    public Brand createBrand(Brand brand) {
        validateBrand(brand);
        return brandRepositoryPort.createBrand(brand);
    }

    /**
     * Validates the brand data before proceeding with its creation.
     *
     * @param brand Domain object representing the brand to be validated.
     * @throws BrandAlreadyExistsException If the brand name already exists.
     * @throws BrandNameTooLongException If the brand name exceeds 50 characters.
     * @throws BrandDescriptionTooLongException If the brand description exceeds 120 characters.
     */
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
