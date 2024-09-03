package com.example.msvc_stock.domain.exceptions.product;

import com.example.msvc_stock.domain.exceptions.DomainException;
import com.example.msvc_stock.domain.exceptions.constants.ProductMessages;

public class ProductExceedsMaximumCategoriesException extends DomainException {
    public ProductExceedsMaximumCategoriesException() {
        super(ProductMessages.PRODUCT_EXCEEDS_MAXIMUM_CATEGORIES.getMessage());
    }
}
