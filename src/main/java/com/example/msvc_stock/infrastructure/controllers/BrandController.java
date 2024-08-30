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
 * REST controller to handle operations related to brands.
 * Maps HTTP requests to appropriate service methods.
 */
@RestController
@RequestMapping("/brand")
@AllArgsConstructor
public class BrandController {
    private final BrandService brandService;

    /**
     * Endpoint to create a new brand.
     *
     * @param createBrandDto Object containing the data for the brand to be created.
     * @return ResponseEntity with the DTO of the created brand and an HTTP status code 201 (CREATED).
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
     * @param direction Direction of the sorting (ASC, DESC).
     * @return ResponseEntity with the DTO of the retrieved brands and an HTTP status code 200 (OK).
     */
    @GetMapping("/get")
    public  ResponseEntity<Paged<BrandDto>> getBrands(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size,
                                                      @RequestParam(defaultValue = "name") String field,
                                                      @RequestParam(defaultValue = "ASC") SorterDirection direction){
        PaginationDto paginationDto = new PaginationDto(page, size);
        SortDto sortDto = new SortDto(field, direction);
        return new ResponseEntity<>(brandService.getBrands(paginationDto, sortDto), HttpStatus.OK);
    }
}
