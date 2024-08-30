package com.example.msvc_stock.infrastructure.jpa.repository.brand;

import com.example.msvc_stock.infrastructure.jpa.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaBrandRepository extends JpaRepository<BrandEntity, Long> {
    Optional<BrandEntity> findByName(String name);
}
