package com.example.msvc_stock.infrastructure.jpa.repository.brand;

import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.ports.out.brand.BrandRepositoryPort;
import com.example.msvc_stock.infrastructure.jpa.mapper.BrandEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class JpaBrandRepositoryAdapter implements BrandRepositoryPort {
    private final JpaBrandRepository jpaBrandRepository;
    private final BrandEntityMapper brandEntityMapper;

    @Override
    public Optional<Brand> getByName(String name) {
        return jpaBrandRepository.findByName(name).map(brandEntityMapper::toDomain);
    }

    @Override
    public Brand createBrand(Brand brand) {
        return brandEntityMapper.toDomain(jpaBrandRepository.save(brandEntityMapper.toEntity(brand)));
    }
}
