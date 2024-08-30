package com.example.msvc_stock.domain.usecases.brand;

import com.example.msvc_stock.domain.exceptions.brand.BrandAlreadyExistsException;
import com.example.msvc_stock.domain.exceptions.brand.BrandDescriptionTooLongException;
import com.example.msvc_stock.domain.exceptions.brand.BrandNameTooLongException;
import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.ports.in.brand.CreateBrandUseCase;
import com.example.msvc_stock.domain.ports.out.brand.BrandRepositoryPort;
/**
 * Implementation of the {@link CreateBrandUseCase} interface for creating a new brand.
 * This class provides the business logic to validate and persist a brand in the system.
 */
public class CreateBrandUseCaseImpl implements CreateBrandUseCase {
    private final BrandRepositoryPort brandRepositoryPort;

    /**
     * Constructs a new instance of {@link CreateBrandUseCaseImpl}.
     *
     * @param brandRepositoryPort The {@link BrandRepositoryPort} used to interact with the persistence layer.
     */
    public CreateBrandUseCaseImpl(BrandRepositoryPort brandRepositoryPort) {
        this.brandRepositoryPort = brandRepositoryPort;
    }

    /**
     * Creates a new brand after validating the provided brand details.
     *
     * @param brand The {@link Brand} object containing the details of the brand to be created.
     * @return The created {@link Brand} object.
     * @throws BrandAlreadyExistsException if a brand with the same name already exists.
     * @throws BrandNameTooLongException if the brand name exceeds the maximum allowed length of 50 characters.
     * @throws BrandDescriptionTooLongException if the brand description exceeds the maximum allowed length of 120 characters.
     */
    @Override
    public Brand createBrand(Brand brand) {
        validateBrand(brand);
        return brandRepositoryPort.createBrand(brand);
    }

    /**
     * Validates the brand details before creation.
     * <p>
     * This method checks that:
     * <ul>
     *     <li>The brand name is unique (no other brand with the same name exists).</li>
     *     <li>The brand name does not exceed 50 characters.</li>
     *     <li>The brand description does not exceed 120 characters.</li>
     * </ul>
     *
     * @param brand The {@link Brand} object to be validated.
     * @throws BrandAlreadyExistsException if a brand with the same name already exists.
     * @throws BrandNameTooLongException if the brand name exceeds 50 characters.
     * @throws BrandDescriptionTooLongException if the brand description exceeds 120 characters.
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
