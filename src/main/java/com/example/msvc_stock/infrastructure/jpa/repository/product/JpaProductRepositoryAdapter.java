package com.example.msvc_stock.infrastructure.jpa.repository.product;

import com.example.msvc_stock.domain.models.Product;
import com.example.msvc_stock.domain.ports.out.product.ProductRepositoryPort;
import com.example.msvc_stock.infrastructure.jpa.mapper.ProductEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JpaProductRepositoryAdapter implements ProductRepositoryPort {
    private final JpaProductRepository jpaProductRepository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public Product createProduct(Product product) {
        return productEntityMapper.toDomain(jpaProductRepository.save(productEntityMapper.toEntity(product)));
    }
}
