package com.example.msvc_stock.infrastructure.jpa.repository.product;

import com.example.msvc_stock.infrastructure.jpa.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
    @Override
    Page<ProductEntity> findAll(Pageable pageable);
}
