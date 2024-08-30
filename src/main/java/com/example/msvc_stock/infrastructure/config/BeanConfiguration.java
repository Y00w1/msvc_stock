package com.example.msvc_stock.infrastructure.config;

import com.example.msvc_stock.domain.ports.in.brand.CreateBrandUseCase;
import com.example.msvc_stock.domain.ports.in.category.CreateCategoryUseCase;
import com.example.msvc_stock.domain.ports.in.category.GetCategoriesUseCase;
import com.example.msvc_stock.domain.ports.out.brand.BrandRepositoryPort;
import com.example.msvc_stock.domain.ports.out.category.CategoryRepositoryPort;
import com.example.msvc_stock.domain.usecases.brand.CreateBrandUseCaseImpl;
import com.example.msvc_stock.domain.usecases.category.CreateCategoryUseCaseImpl;
import com.example.msvc_stock.domain.usecases.category.GetCategoriesUseCaseImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class BeanConfiguration {
    private final CategoryRepositoryPort categoryRepositoryPort;
    private final BrandRepositoryPort brandRepositoryPort;

    @Bean
    public CreateCategoryUseCase createCategoryUseCase(){
        return new CreateCategoryUseCaseImpl(categoryRepositoryPort);
    }
    @Bean
    public GetCategoriesUseCase getCategoriesUseCase(){
        return new GetCategoriesUseCaseImpl(categoryRepositoryPort);
    }
    @Bean
    public CreateBrandUseCase createBrandUseCase(){
        return new CreateBrandUseCaseImpl(brandRepositoryPort);
    }
}
