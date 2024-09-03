package com.example.msvc_stock.domain.exceptions.category;

import com.example.msvc_stock.domain.exceptions.DomainException;
import com.example.msvc_stock.domain.exceptions.constants.CategoryMessages;

public class CategoryNotFoundException extends DomainException {

    public CategoryNotFoundException(Long categoryId) {
        super(CategoryMessages.CATEGORY_NOT_FOUND.formatMessage(categoryId));
    }
}