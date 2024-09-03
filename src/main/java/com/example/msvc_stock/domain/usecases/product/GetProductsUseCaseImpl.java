package com.example.msvc_stock.domain.usecases.product;

import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Pagination;
import com.example.msvc_stock.domain.models.Product;
import com.example.msvc_stock.domain.models.Sorter;
import com.example.msvc_stock.domain.ports.in.product.GetProductsUseCase;
import com.example.msvc_stock.domain.ports.out.product.ProductRepositoryPort;

/**
 * Implementation of the GetProductsUseCase interface.
 * This class is used to get a list of products.
 * It allows to get a list of products with pagination and sorting.
 */
public class GetProductsUseCaseImpl implements GetProductsUseCase {
    public ProductRepositoryPort productRepositoryPort;

    /**
     * Constructor of the GetProductsUseCaseImpl class.
     * It injects the ProductRepositoryPort instance to get the products.
     * @param productRepositoryPort ProductRepositoryPort
     */
    public GetProductsUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    /**
     * Get a list of products with pagination and sorting.
     * @param pagination Pagination
     * @param sorter Sorter
     * @return Paged<Product>
     */
    @Override
    public Paged<Product> getProducts(Pagination pagination, Sorter sorter) {
        return productRepositoryPort.getProducts(pagination, sorter);
    }
}
