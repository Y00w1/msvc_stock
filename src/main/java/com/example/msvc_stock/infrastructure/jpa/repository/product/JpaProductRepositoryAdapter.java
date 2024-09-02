package com.example.msvc_stock.infrastructure.jpa.repository.product;

import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Pagination;
import com.example.msvc_stock.domain.models.Product;
import com.example.msvc_stock.domain.models.Sorter;
import com.example.msvc_stock.domain.ports.out.product.ProductRepositoryPort;
import com.example.msvc_stock.infrastructure.jpa.mapper.ProductEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


@Repository
@AllArgsConstructor
public class JpaProductRepositoryAdapter implements ProductRepositoryPort {
    private final JpaProductRepository jpaProductRepository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public Product createProduct(Product product) {
        return productEntityMapper.toDomain(jpaProductRepository.save(productEntityMapper.toEntity(product)));
    }

    @Override
    public Paged<Product> getProducts(Pagination pagination, Sorter sorter) {
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getSize(),
                Sort.by(Sort.Direction.fromString(sorter.getSorterDirection().name()), sorter.getField())
        );
        return productEntityMapper.toDomainPaged(jpaProductRepository.findAll(pageable));
    }
}
