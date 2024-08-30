package com.example.msvc_stock.domain.exceptions.constants;

public enum CategoryMessages {
    CATEGORY_ALREADY_EXISTS("Category '%s' already exists"),
    CATEGORY_NAME_TOO_LONG("Category name cannot exceed 50 characters"),
    CATEGORY_DESCRIPTION_TOO_LONG("Category description cannot exceed 120 characters"),
    CATEGORY_NAME_CANNOT_BE_BLANK("Category name cannot be blank"),
    CATEGORY_DESCRIPTION_CANNOT_BE_BLANK("Category description cannot be blank");

    private final String message;

    CategoryMessages(String message) {
        this.message = message;
    }

    public String formatMessage(Object... args) {
        return String.format(this.message, args);
    }
}
