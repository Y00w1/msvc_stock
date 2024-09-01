package com.example.msvc_stock.domain.usecases.product;

import com.example.msvc_stock.domain.exceptions.brand.BrandNotFoundException;
import com.example.msvc_stock.domain.exceptions.category.CategoryNotFoundException;
import com.example.msvc_stock.domain.exceptions.product.ProductExceedsMaximumCategoriesException;
import com.example.msvc_stock.domain.exceptions.product.ProductHasDuplicateCategoriesException;
import com.example.msvc_stock.domain.exceptions.product.ProductMustHaveAtLeastOneCategoryException;
import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.models.Category;
import com.example.msvc_stock.domain.models.Product;
import com.example.msvc_stock.domain.ports.out.brand.BrandRepositoryPort;
import com.example.msvc_stock.domain.ports.out.category.CategoryRepositoryPort;
import com.example.msvc_stock.domain.ports.out.product.ProductRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateProductUseCaseImplTest {
    @Mock
    private ProductRepositoryPort productRepositoryPort;
    @Mock
    private CategoryRepositoryPort categoryRepositoryPort;
    @Mock
    private BrandRepositoryPort brandRepositoryPort;

    @InjectMocks
    private CreateProductUseCaseImpl createProductUseCase;

    @Test
    void createProduct() {
        Product product = new Product();
        Brand brand = new Brand();
        brand.setId(1L);
        product.setBrand(brand);
        Category category = new Category();
        category.setId(1L);
        product.setCategories(List.of(category));

        when(brandRepositoryPort.getById(1L)).thenReturn(Optional.of(brand));
        when(categoryRepositoryPort.getById(1L)).thenReturn(Optional.of(category));
        when(productRepositoryPort.createProduct(product)).thenReturn(product);

        Product createdProduct = createProductUseCase.createProduct(product);

        assertNotNull(createdProduct);
    }

    @Test
    void shouldThrowExceptionIfProductHasNoCategories() {
        Product product = new Product();
        product.setCategories(List.of());

        assertThrows(ProductMustHaveAtLeastOneCategoryException.class, () -> {
            createProductUseCase.createProduct(product);
        });
    }

    @Test
    void shouldThrowExceptionIfProductExceedsMaximumCategories() {
        Product product = new Product();
        product.setCategories(Arrays.asList(new Category(), new Category(), new Category(), new Category()));

        assertThrows(ProductExceedsMaximumCategoriesException.class, () -> {
            createProductUseCase.createProduct(product);
        });
    }

    @Test
    void shouldThrowExceptionIfProductHasDuplicateCategories() {
        Category category = new Category();
        category.setId(1L);
        Product product = new Product();
        product.setCategories(Arrays.asList(category, category));

        assertThrows(ProductHasDuplicateCategoriesException.class, () -> {
            createProductUseCase.createProduct(product);
        });
    }

    @Test
    void shouldThrowExceptionIfBrandNotFound() {
        Product product = new Product();
        Brand brand = new Brand();
        brand.setId(1L);
        product.setBrand(brand);
        Category category = new Category();
        category.setId(1L);
        product.setCategories(List.of(category));

        when(brandRepositoryPort.getById(1L)).thenReturn(Optional.empty());

        assertThrows(BrandNotFoundException.class, () -> {
            createProductUseCase.createProduct(product);
        });
    }

    @Test
    void shouldThrowExceptionIfCategoriesNotFound() {
        Product product = new Product();
        Brand brand = new Brand();
        brand.setId(1L);
        product.setBrand(brand);
        Category category = new Category();
        category.setId(1L);
        product.setCategories(List.of(category));

        when(brandRepositoryPort.getById(1L)).thenReturn(Optional.of(brand));
        when(categoryRepositoryPort.getById(1L)).thenReturn(Optional.empty());

        assertThrows(CategoryNotFoundException.class, () -> {
            createProductUseCase.createProduct(product);
        });
    }
}