package com.example.msvc_stock.domain.ports.in.product;

import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Pagination;
import com.example.msvc_stock.domain.models.Product;
import com.example.msvc_stock.domain.models.Sorter;

public interface GetProductsUseCase {
    Paged<Product> getProducts(Pagination pagination, Sorter sorter);
}