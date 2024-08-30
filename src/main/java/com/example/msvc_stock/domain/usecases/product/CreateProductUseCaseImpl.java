package com.example.msvc_stock.domain.usecases.product;

import com.example.msvc_stock.domain.exceptions.product.ProductExceedsMaximumCategoriesException;
import com.example.msvc_stock.domain.exceptions.product.ProductHasDuplicateCategoriesException;
import com.example.msvc_stock.domain.exceptions.product.ProductMustHaveAtLeastOneCategoryException;
import com.example.msvc_stock.domain.models.Category;
import com.example.msvc_stock.domain.models.Product;
import com.example.msvc_stock.domain.ports.in.brand.GetBrandByIdUseCase;
import com.example.msvc_stock.domain.ports.in.category.GetCategoryByIdUseCase;
import com.example.msvc_stock.domain.ports.in.product.CreateProductUseCase;
import com.example.msvc_stock.domain.ports.out.product.ProductRepositoryPort;

import java.util.HashSet;
import java.util.Set;

public class CreateProductUseCaseImpl implements CreateProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;
    private final GetBrandByIdUseCase getBrandByIdUseCase;
    private final GetCategoryByIdUseCase getCategoryByIdUseCase;

    public CreateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort, GetBrandByIdUseCase getBrandByIdUseCase, GetCategoryByIdUseCase getCategoryByIdUseCase) {
        this.productRepositoryPort = productRepositoryPort;
        this.getBrandByIdUseCase = getBrandByIdUseCase;
        this.getCategoryByIdUseCase = getCategoryByIdUseCase;
    }

    @Override
    public Product createProduct(Product product) {
        validateProduct(product);
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
        if (product.getCategories().size() != product.getCategories().stream().distinct().count()) {
            throw new ProductHasDuplicateCategoriesException();
        }
    }

    private void setBrand(Product product) {
        Long brandId = product.getBrand().getId();
        //TODO: change responsibility with the brandRepositoryPort
        product.setBrand(getBrandByIdUseCase.getBrandById(brandId).get());
    }
    private void setCategories(Product product){
        Set<Category> categories = new HashSet<>();
        product.getCategories().forEach(category -> {
            Long categoryId = category.getId();
            //TODO: change responsibility with the categoryRepositoryPort
            categories.add(getCategoryByIdUseCase.getCategoryById(categoryId).get());
        });
        product.setCategories(categories);
    }
}
