package com.example.msvc_stock.domain.ports.in.product;

import com.example.msvc_stock.domain.models.Product;

public interface CreateProductUseCase {
    Product createProduct(Product product);
}
