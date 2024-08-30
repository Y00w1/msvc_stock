package com.example.msvc_stock.domain.ports.out.brand;

import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Pagination;
import com.example.msvc_stock.domain.models.Sorter;

import java.util.Optional;

public interface BrandRepositoryPort {
    Optional<Brand> getByName(String name);
    Optional<Brand> getById(Long id);
    Brand createBrand(Brand brand);
    Paged<Brand> getBrands(Pagination pagination, Sorter sorter);
}
