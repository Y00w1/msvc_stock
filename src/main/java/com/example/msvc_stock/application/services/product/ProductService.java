package com.example.msvc_stock.application.services.product;

import com.example.msvc_stock.application.dto.product.CreateProductDto;
import com.example.msvc_stock.application.dto.product.ProductDto;

public interface ProductService {
    ProductDto createProduct(CreateProductDto product);
}
