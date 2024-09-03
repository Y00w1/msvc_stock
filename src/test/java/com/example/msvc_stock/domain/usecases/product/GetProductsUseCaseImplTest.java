package com.example.msvc_stock.domain.usecases.product;

import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Pagination;
import com.example.msvc_stock.domain.models.Product;
import com.example.msvc_stock.domain.models.Sorter;
import com.example.msvc_stock.domain.ports.in.product.GetProductsUseCase;
import com.example.msvc_stock.domain.ports.out.product.ProductRepositoryPort;
import com.example.msvc_stock.infrastructure.util.enums.SorterDirection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetProductsUseCaseImplTest {
    private GetProductsUseCase getProductsUseCase;

    @Mock
    private ProductRepositoryPort productRepositoryPort;

    private Pagination pagination;
    private Sorter sorter;

    @BeforeEach
    void setUp() {
        getProductsUseCase = new GetProductsUseCaseImpl(productRepositoryPort);
        pagination = new Pagination(1, 10); // Page 1, 10 items per page
        sorter = new Sorter("name", SorterDirection.ASC); // Sort by name, ascending

    }

    @Test
    void testGetProducts_Success() {
        // Arrange
        List<Product> products = List.of(
                new Product(1L, "Product 1", "Description", 10, 9.99, null, null),
                new Product(2L, "Product 2", "Description", 10, 9.99, null, null)
        );
        Paged<Product> pagedProducts = new Paged<>(1, 2, 1, products);
        when(productRepositoryPort.getProducts(pagination, sorter)).thenReturn(pagedProducts);

        // Act
        Paged<Product> result = getProductsUseCase.getProducts(pagination, sorter);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.getTotalElements());
        assertEquals(2, result.getItems().size());
        verify(productRepositoryPort, times(1)).getProducts(pagination, sorter);
    }

    @Test
    void testGetProducts_WithPaginationAndSorting() {
        // Arrange
        List<Product> products = List.of(
                new Product(1L, "Product A", "Description", 10, 9.99, null, null),
                new Product(2L, "Product B", "Description", 10, 9.99, null, null)
        );
        Paged<Product> pagedProducts = new Paged<>(1, 2, 1, products);
        when(productRepositoryPort.getProducts(pagination, sorter)).thenReturn(pagedProducts);

        // Act
        Paged<Product> result = getProductsUseCase.getProducts(pagination, sorter);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getPage());
        assertEquals(2, result.getTotalElements());
        verify(productRepositoryPort, times(1)).getProducts(pagination, sorter);
    }
    @Test
    void testGetProducts_EmptyList() {
        // Arrange
        Paged<Product> emptyPagedProducts = new Paged<>(0, 0, 0, List.of());
        when(productRepositoryPort.getProducts(pagination, sorter)).thenReturn(emptyPagedProducts);

        // Act
        Paged<Product> result = getProductsUseCase.getProducts(pagination, sorter);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.getTotalElements());
        assertTrue(result.getItems().isEmpty());
        verify(productRepositoryPort, times(1)).getProducts(pagination, sorter);
    }

    @Test
    void testGetProducts_VerifyRepositoryCall() {
        // Arrange
        Paged<Product> pagedProducts = new Paged<>(0, 0, 0, List.of());
        when(productRepositoryPort.getProducts(pagination, sorter)).thenReturn(pagedProducts);

        // Act
        getProductsUseCase.getProducts(pagination, sorter);

        // Assert
        verify(productRepositoryPort, times(1)).getProducts(pagination, sorter);
    }
}