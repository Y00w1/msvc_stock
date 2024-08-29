package com.example.msvc_stock.domain.exceptions.constants;

public enum BrandMessages {
    BRAND_ALREADY_EXISTS("Brand '%s' already exists"),
    BRAND_NAME_TOO_LONG("Brand name '%s' cannot exceed 50 characters"),
    BRAND_DESCRIPTION_TOO_LONG("Brand description '%s' cannot exceed 120 characters"),
    BRAND_NAME_CANNOT_BE_BLANK("Brand name cannot be blank"),
    BRAND_DESCRIPTION_CANNOT_BE_BLANK("Brand description cannot be blank");

    private final String message;

    BrandMessages(String message) {
        this.message = message;
    }

    public String formatMessage(Object... args) {
        return String.format(this.message, args);
    }

}
