package com.example.msvc_stock.domain.exceptions.category;

import com.example.msvc_stock.domain.exceptions.constants.CategoryMessages;

public class CategoryDescriptionTooLongException extends RuntimeException{
    public CategoryDescriptionTooLongException() {
        super(CategoryMessages.CATEGORY_DESCRIPTION_TOO_LONG.name());
    }
}
