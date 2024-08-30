package com.example.msvc_stock.domain.exceptions.category;

public class CategoryDescriptionTooLongException extends RuntimeException{
    public CategoryDescriptionTooLongException(String message) {
        super(message);
    }
}
