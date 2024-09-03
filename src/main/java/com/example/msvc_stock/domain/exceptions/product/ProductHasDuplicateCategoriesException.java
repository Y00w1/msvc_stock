package com.example.msvc_stock.domain.exceptions.product;

import com.example.msvc_stock.domain.exceptions.DomainException;
import com.example.msvc_stock.domain.exceptions.constants.ProductMessages;

public class ProductHasDuplicateCategoriesException extends DomainException {
    public ProductHasDuplicateCategoriesException() {
        super(ProductMessages.PRODUCT_HAS_DUPLICATE_CATEGORIES.getMessage());
    }
}
