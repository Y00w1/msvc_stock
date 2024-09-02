package com.example.msvc_stock.infrastructure.controllers;

import com.example.msvc_stock.application.dto.pagination.PaginationDto;
import com.example.msvc_stock.application.dto.pagination.SortDto;
import com.example.msvc_stock.application.dto.product.CreateProductDto;
import com.example.msvc_stock.application.dto.product.ProductDto;
import com.example.msvc_stock.application.services.product.ProductService;
import com.example.msvc_stock.domain.models.Paged;
import com.example.msvc_stock.infrastructure.util.enums.SorterDirection;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * REST controller to handle operations related to products.
 * Maps HTTP requests to appropriate service methods.
 */
@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    /**
     * Endpoint to create a new product.
     *
     * @param productDto Object containing the data for the product to be created.
     * @return ResponseEntity with the DTO of the created product.
     */
    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody CreateProductDto productDto){
        return ResponseEntity.ok(productService.createProduct(productDto));
    }

    /**
     * Endpoint to get a list of products.
     *
     * @param page Page number to be retrieved.
     * @param size Number of elements to be retrieved.
     * @param field Field to be used for sorting.
     * @param sortDirection Direction of the sorting.
     * @return ResponseEntity with the DTO of the retrieved products.
     */
    @GetMapping("/get")
    public ResponseEntity<Paged<ProductDto>> getProducts(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size,
                                                         @RequestParam(defaultValue = "name") String field,
                                                         @RequestParam(defaultValue = "ASC") String sortDirection){
        PaginationDto paginationDto = new PaginationDto(page, size);
        SortDto sortDto = new SortDto(field, SorterDirection.valueOf(sortDirection.toUpperCase()));
        return ResponseEntity.ok(productService.getProducts(paginationDto, sortDto));
    }
}
