package com.example.msvc_stock.domain.exceptions.category;

import com.example.msvc_stock.domain.exceptions.DomainException;
import com.example.msvc_stock.domain.exceptions.constants.CategoryMessages;

public class CategoryNameIsRequiredException extends DomainException {
    public CategoryNameIsRequiredException() {
        super(CategoryMessages.CATEGORY_NAME_REQUIRED.name());
    }
}
