package com.example.msvc_stock.application.services.product;

import com.example.msvc_stock.application.dto.mapper.product.ProductMapper;
import com.example.msvc_stock.application.dto.product.CreateProductDto;
import com.example.msvc_stock.application.dto.product.ProductDto;
import com.example.msvc_stock.domain.models.Product;
import com.example.msvc_stock.domain.ports.in.product.CreateProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final CreateProductUseCase createProductUseCase;
    private final ProductMapper productMapper;

    @Override
    public ProductDto createProduct(CreateProductDto product) {
        return productMapper.toDto(createProductUseCase.createProduct(productMapper.toDomain(product)));
    }
}
