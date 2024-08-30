package com.example.msvc_stock.domain.exceptions.category;

public class CategoryNameTooLongException extends RuntimeException{
    public CategoryNameTooLongException(String message) {
        super(message);
    }
}
