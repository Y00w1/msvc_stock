package com.example.msvc_stock.infrastructure.exceptions.sort;

public class InvalidSorterDirectionException extends RuntimeException {
    public InvalidSorterDirectionException(String message) {
        super(message);
    }
}
