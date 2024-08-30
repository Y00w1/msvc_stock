package com.example.msvc_stock.domain.exceptions.category;

import com.example.msvc_stock.domain.exceptions.DomainException;
import com.example.msvc_stock.domain.exceptions.constants.CategoryMessages;

public class CategoryAlreadyExistsException extends DomainException {
    public CategoryAlreadyExistsException(String categoryName) {
        super(CategoryMessages.CATEGORY_ALREADY_EXISTS.formatMessage(categoryName));
    }
}
