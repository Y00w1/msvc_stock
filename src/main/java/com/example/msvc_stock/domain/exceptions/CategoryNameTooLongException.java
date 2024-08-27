package com.example.msvc_stock.domain.exceptions;

public class CategoryNameTooLongException extends RuntimeException{
    public CategoryNameTooLongException(String message) {
        super(message);
    }
}
