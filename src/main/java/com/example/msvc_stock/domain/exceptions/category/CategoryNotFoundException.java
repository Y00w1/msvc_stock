package com.example.msvc_stock.domain.exceptions.category;

import com.example.msvc_stock.domain.exceptions.DomainException;

public class CategoryNotFoundException extends DomainException {

    public CategoryNotFoundException() {
        super("Category not found");
    }
}
//TODO: Implements the constants messages for the errors