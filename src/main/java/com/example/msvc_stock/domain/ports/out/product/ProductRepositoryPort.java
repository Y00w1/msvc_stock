package com.example.msvc_stock.domain.ports.out.product;

import com.example.msvc_stock.domain.models.Product;

public interface ProductRepositoryPort {
    Product createProduct(Product product);
}
