package com.example.msvc_stock.domain.exceptions.category;

import com.example.msvc_stock.domain.exceptions.DomainException;
import com.example.msvc_stock.domain.exceptions.constants.CategoryMessages;

public class CategoryNameTooLongException extends DomainException {
    public CategoryNameTooLongException() {
        super(CategoryMessages.CATEGORY_NAME_TOO_LONG.name());
    }
}
