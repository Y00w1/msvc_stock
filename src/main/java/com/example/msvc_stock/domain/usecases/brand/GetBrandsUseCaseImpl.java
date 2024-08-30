package com.example.msvc_stock.domain.usecases.brand;

import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Pagination;
import com.example.msvc_stock.domain.models.Sorter;
import com.example.msvc_stock.domain.ports.in.brand.GetBrandsUseCase;
import com.example.msvc_stock.domain.ports.out.brand.BrandRepositoryPort;

/**
 * Implementation of the use case for retrieving brands.
 * Contains the business logic for fetching brands with pagination and sorting.
 */
public class GetBrandsUseCaseImpl implements GetBrandsUseCase {
    private final BrandRepositoryPort brandRepositoryPort;

    /**
     * Constructor that injects the dependency of the brand repository port.
     *
     * @param brandRepositoryPort Repository port for managing brands.
     */
    public GetBrandsUseCaseImpl(BrandRepositoryPort brandRepositoryPort) {
        this.brandRepositoryPort = brandRepositoryPort;
    }

    /**
     * Retrieves a paginated and sorted list of brands.
     *
     * @param pagination Pagination object containing page number and size.
     * @param sorter Sorter object containing sorting field and direction.
     * @return A paginated list of brands.
     */
    @Override
    public Paged<Brand> getBrands(Pagination pagination, Sorter sorter) {
        return brandRepositoryPort.getBrands(pagination, sorter);
    }
}
