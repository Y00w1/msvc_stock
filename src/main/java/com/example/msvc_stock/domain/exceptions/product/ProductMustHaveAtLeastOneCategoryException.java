package com.example.msvc_stock.domain.exceptions.product;

import com.example.msvc_stock.domain.exceptions.DomainException;
import com.example.msvc_stock.domain.exceptions.constants.ProductMessages;

public class ProductMustHaveAtLeastOneCategoryException extends DomainException {
    public ProductMustHaveAtLeastOneCategoryException() {
        super(ProductMessages.PRODUCT_MUST_HAVE_AT_LEAST_ONE_CATEGORY.getMessage());
    }
}
