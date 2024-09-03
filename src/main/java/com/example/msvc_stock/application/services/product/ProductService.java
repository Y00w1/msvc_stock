package com.example.msvc_stock.application.services.product;

import com.example.msvc_stock.application.dto.pagination.PaginationDto;
import com.example.msvc_stock.application.dto.pagination.SortDto;
import com.example.msvc_stock.application.dto.product.CreateProductDto;
import com.example.msvc_stock.application.dto.product.ProductDto;
import com.example.msvc_stock.domain.models.Paged;

public interface ProductService {
    ProductDto createProduct(CreateProductDto product);
    Paged<ProductDto> getProducts(PaginationDto paginationDto, SortDto sortDto);
}
