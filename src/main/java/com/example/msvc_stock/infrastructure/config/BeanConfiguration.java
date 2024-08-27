package com.example.msvc_stock.infrastructure.config;

import com.example.msvc_stock.domain.ports.in.CreateCategoryUseCase;
import com.example.msvc_stock.domain.ports.in.GetCategoriesUseCase;
import com.example.msvc_stock.domain.ports.out.CategoryRepositoryPort;
import com.example.msvc_stock.domain.usecases.CreateCategoryUseCaseImpl;
import com.example.msvc_stock.domain.usecases.GetCategoriesUseCaseImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class BeanConfiguration {
    private final CategoryRepositoryPort categoryRepositoryPort;

    @Bean
    public CreateCategoryUseCase createCategoryUseCase(){
        return new CreateCategoryUseCaseImpl(categoryRepositoryPort);
    }
    @Bean
    public GetCategoriesUseCase getCategoriesUseCase(){
        return new GetCategoriesUseCaseImpl(categoryRepositoryPort);
    }
}
