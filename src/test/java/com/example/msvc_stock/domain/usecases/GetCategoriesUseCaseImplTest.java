package com.example.msvc_stock.domain.usecases;

import com.example.msvc_stock.domain.models.Category;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.domain.models.Pagination;
import com.example.msvc_stock.domain.models.Sorter;
import com.example.msvc_stock.domain.ports.in.GetCategoriesUseCase;
import com.example.msvc_stock.domain.ports.out.CategoryRepositoryPort;
import com.example.msvc_stock.infrastructure.util.enums.SorterDirection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class GetCategoriesUseCaseImplTest {
    private GetCategoriesUseCase getCategoriesUseCase;

    @Mock
    private CategoryRepositoryPort categoryRepositoryPort;

    private Paged<Category> pagedCategories;

    @BeforeEach
    void setUp() {
        getCategoriesUseCase = new GetCategoriesUseCaseImpl(categoryRepositoryPort);
        pagedCategories = new Paged<>(0,0,0, Collections.emptyList());
    }

    @Test
    void getCategories_AscendingOrder() {
        Pagination pagination = new Pagination(0, 10);
        Sorter sorter = new Sorter("name", SorterDirection.ASC);
        List<Category> sortedCategories = Arrays.asList(
                new Category(1L, "Apple", "Description A"),
                new Category(2L, "Banana", "Description B")
        );
        pagedCategories = new Paged<>(2, 1, 0, sortedCategories);

        when(categoryRepositoryPort.findAll(pagination, sorter)).thenReturn(pagedCategories);

        Paged<Category> categories = getCategoriesUseCase.getCategories(pagination, sorter);

        assertEquals(pagedCategories, categories);
        assertEquals("Apple", categories.getItems().get(0).getName());
        assertEquals("Banana", categories.getItems().get(1).getName());
    }

    @Test
    void getCategories_DescendingOrder() {
        Pagination pagination = new Pagination(0, 10);
        Sorter sorter = new Sorter("name", SorterDirection.DESC);
        List<Category> sortedCategories = Arrays.asList(
                new Category(2L, "Banana", "Description B"),
                new Category(1L, "Apple", "Description A")
        );
        pagedCategories = new Paged<>(2, 1, 0, sortedCategories);

        when(categoryRepositoryPort.findAll(pagination, sorter)).thenReturn(pagedCategories);

        Paged<Category> categories = getCategoriesUseCase.getCategories(pagination, sorter);

        assertEquals(pagedCategories, categories);
        assertEquals("Banana", categories.getItems().get(0).getName());
        assertEquals("Apple", categories.getItems().get(1).getName());
    }

    @Test
    void getCategories_PaginationWithResults() {
        Pagination pagination = new Pagination(0, 1);
        Sorter sorter = new Sorter("name", SorterDirection.ASC);
        List<Category> singleCategoryPage = Collections.singletonList(
                new Category(1L, "Apple", "Description A")
        );
        pagedCategories = new Paged<>(2, 2, 0, singleCategoryPage);

        when(categoryRepositoryPort.findAll(pagination, sorter)).thenReturn(pagedCategories);

        Paged<Category> categories = getCategoriesUseCase.getCategories(pagination, sorter);

        assertEquals(1, categories.getItems().size());
        assertEquals("Apple", categories.getItems().get(0).getName());
        assertEquals(2, categories.getTotal());
    }

    @Test
    void getCategories_PaginationNoResults() {
        Pagination pagination = new Pagination(2, 10);
        Sorter sorter = new Sorter("name", SorterDirection.ASC);

        when(categoryRepositoryPort.findAll(pagination, sorter)).thenReturn(pagedCategories);

        Paged<Category> categories = getCategoriesUseCase.getCategories(pagination, sorter);

        assertTrue(categories.getItems().isEmpty());
        assertEquals(0, categories.getTotal());
    }
}
