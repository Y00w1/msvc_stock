package com.example.msvc_stock.infrastructure.jpa.repository.brand;

import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Pagination;
import com.example.msvc_stock.domain.models.Sorter;
import com.example.msvc_stock.domain.ports.out.brand.BrandRepositoryPort;
import com.example.msvc_stock.infrastructure.jpa.mapper.BrandEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class JpaBrandRepositoryAdapter implements BrandRepositoryPort {
    private final JpaBrandRepository jpaBrandRepository;
    private final BrandEntityMapper brandEntityMapper;

    @Override
    public Optional<Brand> getByName(String name) {
        return Optional.of(brandEntityMapper.toDomain((jpaBrandRepository.findByName(name))));
    }

    @Override
    public Optional<Brand> getById(Long id) {
        return jpaBrandRepository.findById(id).map(brandEntityMapper::toDomain);
    }

    @Override
    public Brand createBrand(Brand brand) {
        return brandEntityMapper.toDomain(jpaBrandRepository.save(brandEntityMapper.toEntity(brand)));
    }

    @Override
    public Paged<Brand> getBrands(Pagination pagination, Sorter sorter) {
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getSize(), Sort.by(Sort.Direction.fromString(sorter.getSorterDirection().name()), sorter.getField()));
        return brandEntityMapper.toDomainPaged(jpaBrandRepository.findAll(pageable));
    }

}
