package com.example.msvc_stock.domain.exceptions.constants;

public enum BrandMessages {
    BRAND_ALREADY_EXISTS("Brand '%s' already exists"),
    BRAND_NAME_TOO_LONG("Brand name '%s' cannot exceed 50 characters"),
    BRAND_DESCRIPTION_TOO_LONG("Brand description '%s' cannot exceed 120 characters"),
    BRAND_NOT_FOUND("Brand with id '%s' not found.");

    private final String message;

    BrandMessages(String message) {
        this.message = message;
    }

    public String formatMessage(Object... args) {
        return String.format(this.message, args);
    }

}
