package com.example.msvc_stock.domain.exceptions;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
