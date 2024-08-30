package com.example.msvc_stock.domain.exceptions.category;

import com.example.msvc_stock.domain.exceptions.DomainException;
import com.example.msvc_stock.domain.exceptions.constants.CategoryMessages;

public class CategoryDescriptionIsRequiredException extends DomainException {
    public CategoryDescriptionIsRequiredException() {
        super(CategoryMessages.CATEGORY_DESCRIPTION_CANNOT_BE_BLANK.name());
    }
}
