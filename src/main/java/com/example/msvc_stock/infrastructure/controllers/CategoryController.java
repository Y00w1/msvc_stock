package com.example.msvc_stock.infrastructure.controllers;

import com.example.msvc_stock.application.dto.category.CategoryDto;
import com.example.msvc_stock.application.dto.category.CreateCategoryDto;
import com.example.msvc_stock.application.dto.pagination.PaginationDto;
import com.example.msvc_stock.application.dto.pagination.SortDto;
import com.example.msvc_stock.application.services.CategoryService;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.infrastructure.util.enums.SorterDirection;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller to handle operations related to categories.
 *  * Maps HTTP requests to appropriate service methods.
 */
@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    /**
     * Endpoint to create a new category.
     *
     * @param createCategoryDto Object containing the data for the category to be created.
     * @return ResponseEntity with the DTO of the created category and an HTTP status code 201 (CREATED).
     */
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CreateCategoryDto createCategoryDto) {
        return new ResponseEntity<>(categoryService.createCategory(createCategoryDto), HttpStatus.CREATED);
    }

    /**
     * Endpoint to get all categories.
     *
     * @param page Page number to be retrieved.
     * @param size Number of elements to be retrieved.
     * @param field Field to be sorted by.
     * @param direction Direction of the sorting (ASC, DESC).
     * @return ResponseEntity with the DTO of the retrieved categories and an HTTP status code 200 (OK).
     */
    @GetMapping("/get")
    public ResponseEntity<Paged<CategoryDto>> getCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String field,
            @RequestParam(defaultValue = "ASC") SorterDirection direction) {
        PaginationDto paginationDto = new PaginationDto(page, size);
        SortDto sortDto = new SortDto(field, direction);
        return new ResponseEntity<>(categoryService.getCategories(paginationDto, sortDto), HttpStatus.OK);
    }
}
