package com.example.msvc_stock.infrastructure.config;

import com.example.msvc_stock.domain.ports.in.brand.CreateBrandUseCase;
import com.example.msvc_stock.domain.ports.in.brand.GetBrandByIdUseCase;
import com.example.msvc_stock.domain.ports.in.brand.GetBrandsUseCase;
import com.example.msvc_stock.domain.ports.in.category.CreateCategoryUseCase;
import com.example.msvc_stock.domain.ports.in.category.GetCategoriesUseCase;
import com.example.msvc_stock.domain.ports.in.category.GetCategoryByIdUseCase;
import com.example.msvc_stock.domain.ports.in.product.CreateProductUseCase;
import com.example.msvc_stock.domain.ports.in.product.GetProductsUseCase;
import com.example.msvc_stock.domain.ports.out.brand.BrandRepositoryPort;
import com.example.msvc_stock.domain.ports.out.category.CategoryRepositoryPort;
import com.example.msvc_stock.domain.ports.out.product.ProductRepositoryPort;
import com.example.msvc_stock.domain.usecases.brand.CreateBrandUseCaseImpl;
import com.example.msvc_stock.domain.usecases.brand.GetBrandByIdUseCaseImpl;
import com.example.msvc_stock.domain.usecases.brand.GetBrandsUseCaseImpl;
import com.example.msvc_stock.domain.usecases.category.CreateCategoryUseCaseImpl;
import com.example.msvc_stock.domain.usecases.category.GetCategoriesUseCaseImpl;
import com.example.msvc_stock.domain.usecases.category.GetCategoryByIdUseCaseImpl;
import com.example.msvc_stock.domain.usecases.product.CreateProductUseCaseImpl;
import com.example.msvc_stock.domain.usecases.product.GetProductsUseCaseImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
@AllArgsConstructor
public class BeanConfiguration {
    private final CategoryRepositoryPort categoryRepositoryPort;
    private final BrandRepositoryPort brandRepositoryPort;
    private final ProductRepositoryPort productRepositoryPort;

    @Bean
    public CreateCategoryUseCase createCategoryUseCase() {
        return new CreateCategoryUseCaseImpl(categoryRepositoryPort);
    }

    @Bean
    public GetCategoriesUseCase getCategoriesUseCase() {
        return new GetCategoriesUseCaseImpl(categoryRepositoryPort);
    }

    @Bean
    public CreateBrandUseCase createBrandUseCase() {
        return new CreateBrandUseCaseImpl(brandRepositoryPort);
    }

    @Bean
    public GetBrandsUseCase getBrandsUseCase() {
        return new GetBrandsUseCaseImpl(brandRepositoryPort);
    }

    @Bean
    public CreateProductUseCase createProductUseCase() {
        return new CreateProductUseCaseImpl(productRepositoryPort, categoryRepositoryPort, brandRepositoryPort);
    }
    @Bean
    public GetProductsUseCase getProductsUseCase() {
        return new GetProductsUseCaseImpl(productRepositoryPort);
    }
}
