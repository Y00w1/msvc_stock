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

/**
 * Implementation of the CreateProductUseCase interface.
 * This class handles the creation of a Product, including validation and setting of related entities.
 */
public class CreateProductUseCaseImpl implements CreateProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;
    private final CategoryRepositoryPort categoryRepositoryPort;
    private final BrandRepositoryPort brandRepositoryPort;

    /**
     * Constructor for CreateProductUseCaseImpl.
     *
     * @param productRepositoryPort the product repository port
     * @param categoryRepositoryPort the category repository port
     * @param brandRepositoryPort the brand repository port
     */
    public CreateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort, CategoryRepositoryPort categoryRepositoryPort, BrandRepositoryPort brandRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
        this.categoryRepositoryPort = categoryRepositoryPort;
        this.brandRepositoryPort = brandRepositoryPort;
    }

    /**
     * Creates a new Product.
     *
     * @param product the product to create
     * @return the created product
     */
    @Override
    public Product createProduct(Product product) {
        validateProduct(product);
        checkForDuplicateCategories(product);
        setBrand(product);
        setCategories(product);
        return productRepositoryPort.createProduct(product);
    }

    /**
     * Validates the product.
     * Ensures the product has at least one category and does not exceed the maximum number of categories.
     *
     * @param product the product to validate
     */
    private void validateProduct(Product product) {
        if (product.getCategories().isEmpty()) {
            throw new ProductMustHaveAtLeastOneCategoryException();
        }
        if (product.getCategories().size() > 3) {
            throw new ProductExceedsMaximumCategoriesException();
        }
    }

    /**
     * Checks for duplicate categories in the product.
     *
     * @param product the product to check
     */
    private void checkForDuplicateCategories(Product product) {
        Set<Long> categoryIds = new HashSet<>();
        for (Category category : product.getCategories()) {
            if (!categoryIds.add(category.getId())) {
                throw new ProductHasDuplicateCategoriesException();
            }
        }
    }

    /**
     * Sets the brand for the product.
     *
     * @param product the product to set the brand for
     */
    private void setBrand(Product product) {
        Long brandId = product.getBrand().getId();
        Brand brand = brandRepositoryPort.getById(brandId)
                .orElseThrow(() -> new BrandNotFoundException(brandId));
        product.setBrand(brand);
    }

    /**
     * Sets the categories for the product.
     *
     * @param product the product to set the categories for
     */
    private void setCategories(Product product){
        List<Category> categories = new ArrayList<>();
        product.getCategories().forEach(category -> {
            Long categoryId = category.getId();
            Category newCategory = categoryRepositoryPort.getById(categoryId)
                    .orElseThrow(() -> new CategoryNotFoundException(categoryId));
            categories.add(newCategory);
        });
        product.setCategories(categories);
    }
}
