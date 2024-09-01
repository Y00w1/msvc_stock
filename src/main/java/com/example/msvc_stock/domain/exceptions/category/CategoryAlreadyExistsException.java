package com.example.msvc_stock.domain.exceptions.category;

import com.example.msvc_stock.domain.exceptions.constants.CategoryMessages;

public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException(String categoryName) {
        super(CategoryMessages.CATEGORY_ALREADY_EXISTS.formatMessage(categoryName));
    }
}
