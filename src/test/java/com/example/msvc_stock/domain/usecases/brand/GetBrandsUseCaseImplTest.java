package com.example.msvc_stock.domain.usecases.brand;

import com.example.msvc_stock.domain.models.Brand;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Pagination;
import com.example.msvc_stock.domain.models.Sorter;
import com.example.msvc_stock.domain.ports.out.brand.BrandRepositoryPort;
import com.example.msvc_stock.infrastructure.util.enums.SorterDirection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GetBrandsUseCaseImplTest {
    @InjectMocks
    private GetBrandsUseCaseImpl getBrandsUseCase;

    @Mock
    private BrandRepositoryPort brandRepositoryPort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getBrandsAscendingOrder() {
        List<Brand> brands = Arrays.asList(
                new Brand(1L, "BrandA", "DescriptionA"),
                new Brand(2L, "BrandB", "DescriptionB")
        );
        Paged<Brand> pagedBrands = new Paged<>(1, 2, 1, brands);
        Pagination pagination = new Pagination(1, 2);
        Sorter sorter = new Sorter("name", SorterDirection.ASC);

        when(brandRepositoryPort.getBrands(pagination, sorter)).thenReturn(pagedBrands);

        Paged<Brand> result = getBrandsUseCase.getBrands(pagination, sorter);

        assertEquals(2, result.getTotalElements());
        assertEquals("BrandA", result.getItems().get(0).getName());
        assertEquals("BrandB", result.getItems().get(1).getName());
    }

    @Test
    void getBrandsDescendingOrder() {
        List<Brand> brands = Arrays.asList(
                new Brand(1L, "BrandB", "DescriptionB"),
                new Brand(2L, "BrandA", "DescriptionA")
        );
        Paged<Brand> pagedBrands = new Paged<>(1, 2, 2, brands);
        Pagination pagination = new Pagination(1, 2);
        Sorter sorter = new Sorter("name", SorterDirection.ASC);

        when(brandRepositoryPort.getBrands(pagination, sorter)).thenReturn(pagedBrands);

        Paged<Brand> result = getBrandsUseCase.getBrands(pagination, sorter);

        assertEquals(2, result.getTotalElements());
        assertEquals("BrandB", result.getItems().get(0).getName());
        assertEquals("BrandA", result.getItems().get(1).getName());
    }

    @Test
    void getBrandsNoResults() {
        Paged<Brand> pagedBrands = new Paged<>(0, 0, 0, Collections.emptyList());
        Pagination pagination = new Pagination(1, 2);
        Sorter sorter = new Sorter("name", SorterDirection.ASC);

        when(brandRepositoryPort.getBrands(pagination, sorter)).thenReturn(pagedBrands);

        Paged<Brand> result = getBrandsUseCase.getBrands(pagination, sorter);

        assertEquals(0, result.getTotalPages());
        assertEquals(0, result.getItems().size());
    }
}