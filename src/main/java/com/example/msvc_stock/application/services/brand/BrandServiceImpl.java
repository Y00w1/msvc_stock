package com.example.msvc_stock.application.services.brand;

import com.example.msvc_stock.application.dto.brand.BrandDto;
import com.example.msvc_stock.application.dto.brand.CreateBrandDto;
import com.example.msvc_stock.application.dto.mapper.brand.BrandMapper;
import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.ports.in.brand.CreateBrandUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService{
    private final CreateBrandUseCase createBrandUseCase;
    private final BrandMapper brandMapper;

    @Override
    public BrandDto create(CreateBrandDto createBrandDto) {
        Brand brandToCreate = brandMapper.toDomain(createBrandDto);
        return brandMapper.toDto(createBrandUseCase.createBrand(brandToCreate));
    }
}
