package com.example.msvc_stock.domain.usecases.product;

import com.example.msvc_stock.domain.exceptions.brand.BrandNotFoundException;
import com.example.msvc_stock.domain.exceptions.category.CategoryNotFoundException;
import com.example.msvc_stock.domain.exceptions.product.ProductExceedsMaximumCategoriesException;
import com.example.msvc_stock.domain.exceptions.product.ProductHasDuplicateCategoriesException;
import com.example.msvc_stock.domain.exceptions.product.ProductMustHaveAtLeastOneCategoryException;
import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.models.Category;
import com.example.msvc_stock.domain.models.Product;
import com.example.msvc_stock.domain.ports.in.product.CreateProductUseCase;
import com.example.msvc_stock.domain.ports.out.brand.BrandRepositoryPort;
import com.example.msvc_stock.domain.ports.out.category.CategoryRepositoryPort;
import com.example.msvc_stock.domain.ports.out.product.ProductRepositoryPort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateProductUseCaseImpl implements CreateProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;
    private final CategoryRepositoryPort categoryRepositoryPort;
    private final BrandRepositoryPort brandRepositoryPort;

    public CreateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort, CategoryRepositoryPort categoryRepositoryPort, BrandRepositoryPort brandRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
        this.categoryRepositoryPort = categoryRepositoryPort;
        this.brandRepositoryPort = brandRepositoryPort;
    }

    @Override
    public Product createProduct(Product product) {
        validateProduct(product);
        checkForDuplicateCategories(product);
        setBrand(product);
        setCategories(product);
        return productRepositoryPort.createProduct(product);
    }

    private void validateProduct(Product product) {
        if (product.getCategories().isEmpty()) {
            throw new ProductMustHaveAtLeastOneCategoryException();
        }
        if (product.getCategories().size() > 3) {
            throw new ProductExceedsMaximumCategoriesException();
        }
    }

    private void checkForDuplicateCategories(Product product) {
        Set<Long> categoryIds = new HashSet<>();
        for (Category category : product.getCategories()) {
            if (!categoryIds.add(category.getId())) {
                throw new ProductHasDuplicateCategoriesException();
            }
        }
    }

    private void setBrand(Product product) {
        Long brandId = product.getBrand().getId();
        Brand brand = brandRepositoryPort.getById(brandId)
                .orElseThrow(() -> new BrandNotFoundException(brandId));
        product.setBrand(brand);
    }
    private void setCategories(Product product){
        List<Category> categories = new ArrayList<>();
        product.getCategories().forEach(category -> {
            Long categoryId = category.getId();
            Category newCategory = categoryRepositoryPort.getById(categoryId)
                    .orElseThrow(() -> new CategoryNotFoundException());
            categories.add(newCategory);
        });
        product.setCategories(categories);
    }
}
