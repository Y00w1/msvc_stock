package com.example.msvc_stock.infrastructure.jpa.repository.brand;

import com.example.msvc_stock.infrastructure.jpa.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBrandRepository extends JpaRepository<BrandEntity, Long> {
    BrandEntity findByName(String name);
}
