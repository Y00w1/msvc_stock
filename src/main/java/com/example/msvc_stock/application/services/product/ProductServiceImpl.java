package com.example.msvc_stock.application.services.product;

import com.example.msvc_stock.application.dto.mapper.pagination.PaginationMapper;
import com.example.msvc_stock.application.dto.mapper.pagination.SortMapper;
import com.example.msvc_stock.application.dto.mapper.product.ProductMapper;
import com.example.msvc_stock.application.dto.pagination.PaginationDto;
import com.example.msvc_stock.application.dto.pagination.SortDto;
import com.example.msvc_stock.application.dto.product.CreateProductDto;
import com.example.msvc_stock.application.dto.product.ProductDto;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Pagination;
import com.example.msvc_stock.domain.models.Sorter;
import com.example.msvc_stock.domain.ports.in.product.CreateProductUseCase;
import com.example.msvc_stock.domain.ports.in.product.GetProductsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final CreateProductUseCase createProductUseCase;
    private final GetProductsUseCase getProductsUseCase;
    private final ProductMapper productMapper;
    private final PaginationMapper paginationMapper;
    private final SortMapper sortMapper;

    @Override
    public ProductDto createProduct(CreateProductDto product) {
        return productMapper.toDto(createProductUseCase.createProduct(productMapper.toDomain(product)));
    }

    @Override
    public Paged<ProductDto> getProducts(PaginationDto paginationDto, SortDto sortDto) {
        Pagination pagination = paginationMapper.toDomain(paginationDto);
        Sorter sorter = sortMapper.toDomain(sortDto);
        return productMapper.toDtoPaged(getProductsUseCase.getProducts(pagination, sorter));
    }
}
