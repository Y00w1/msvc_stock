package com.example.msvc_stock.domain.exceptions.category;

import com.example.msvc_stock.domain.exceptions.constants.CategoryMessages;

public class CategoryDescriptionIsRequiredException extends RuntimeException{
    public CategoryDescriptionIsRequiredException() {
        super(CategoryMessages.CATEGORY_DESCRIPTION_REQUIRED.name());
    }
}
