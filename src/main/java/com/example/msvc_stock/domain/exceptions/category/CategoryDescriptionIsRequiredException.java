package com.example.msvc_stock.domain.exceptions.category;

public class CategoryDescriptionIsRequiredException extends RuntimeException{
    public CategoryDescriptionIsRequiredException(String message) {
        super(message);
    }
}
