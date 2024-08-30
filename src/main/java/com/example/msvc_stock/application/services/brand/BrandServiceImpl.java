package com.example.msvc_stock.application.services.brand;

import com.example.msvc_stock.application.dto.brand.BrandDto;
import com.example.msvc_stock.application.dto.brand.CreateBrandDto;
import com.example.msvc_stock.application.dto.mapper.brand.BrandMapper;
import com.example.msvc_stock.application.dto.mapper.pagination.PaginationMapper;
import com.example.msvc_stock.application.dto.mapper.pagination.SortMapper;
import com.example.msvc_stock.application.dto.pagination.PaginationDto;
import com.example.msvc_stock.application.dto.pagination.SortDto;
import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.ports.in.brand.CreateBrandUseCase;
import com.example.msvc_stock.domain.ports.in.brand.GetBrandsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService{
    private final CreateBrandUseCase createBrandUseCase;
    private final GetBrandsUseCase getBrandsUseCase;
    private final BrandMapper brandMapper;
    private final SortMapper sortMapper;
    private final PaginationMapper paginationMapper;

    @Override
    public BrandDto create(CreateBrandDto createBrandDto) {
        Brand brandToCreate = brandMapper.toDomain(createBrandDto);
        return brandMapper.toDto(createBrandUseCase.createBrand(brandToCreate));
    }

    @Override
    public Paged<BrandDto> getBrands(PaginationDto paginationDto, SortDto sortDto) {
        return brandMapper.toDtoPaged(getBrandsUseCase.getBrands(
                paginationMapper.toDomain(paginationDto),
                sortMapper.toDomain(sortDto))
        );
    }
}
