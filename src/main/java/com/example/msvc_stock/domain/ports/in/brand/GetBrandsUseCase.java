package com.example.msvc_stock.domain.ports.in.brand;

import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Pagination;
import com.example.msvc_stock.domain.models.Sorter;

public interface GetBrandsUseCase {
    Paged<Brand> getBrands(Pagination pagination, Sorter sorter);
}
