package com.example.msvc_stock.infrastructure.controllers;

import com.example.msvc_stock.application.dto.brand.BrandDto;
import com.example.msvc_stock.application.dto.brand.CreateBrandDto;
import com.example.msvc_stock.application.dto.pagination.PaginationDto;
import com.example.msvc_stock.application.dto.pagination.SortDto;
import com.example.msvc_stock.application.services.brand.BrandService;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.infrastructure.util.enums.SorterDirection;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing brand-related operations.
 * <p>
 * This controller handles the HTTP requests related to brands.
 */
@RestController
@RequestMapping("/brand")
@AllArgsConstructor
public class BrandController {
    private final BrandService brandService;

    /**
     * Creates a new brand.
     * <p>
     * This endpoint accepts a POST request with a {@link CreateBrandDto} object in the request body,
     * validates it, and creates a new brand based on the provided data.
     *
     * @param createBrandDto The {@link CreateBrandDto} object containing the brand details to be created.
     * @return A {@link ResponseEntity} containing the created {@link BrandDto} object and the HTTP status code {@code 201 CREATED}.
     */
    @PostMapping("/create")
    public ResponseEntity<BrandDto> createBrand(@Valid @RequestBody CreateBrandDto createBrandDto) {
        return new ResponseEntity<>(brandService.create(createBrandDto), HttpStatus.CREATED);
    }

    /**
     * Endpoint to get all brands.
     *
     * @param page Page number to be retrieved.
     * @param size Number of elements to be retrieved.
     * @param field Field to be sorted by.
     * @param sortDirection Direction of the sorting (ASC, DESC).
     * @return ResponseEntity with the DTO of the retrieved brands and an HTTP status code 200 (OK).
     */
    @GetMapping("/get")
    public  ResponseEntity<Paged<BrandDto>> getBrands(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size,
                                                      @RequestParam(defaultValue = "name") String field,
                                                      @RequestParam(defaultValue = "ASC") String sortDirection){
        PaginationDto paginationDto = new PaginationDto(page, size);
        SortDto sortDto = new SortDto(field, SorterDirection.valueOf(sortDirection.toUpperCase()));
        return new ResponseEntity<>(brandService.getBrands(paginationDto, sortDto), HttpStatus.OK);
    }
}
