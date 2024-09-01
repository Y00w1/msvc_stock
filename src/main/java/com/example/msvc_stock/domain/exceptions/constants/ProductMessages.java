package com.example.msvc_stock.domain.exceptions.constants;

public enum ProductMessages {
    PRODUCT_MUST_HAVE_AT_LEAST_ONE_CATEGORY("Product must have at least one category associated."),
    PRODUCT_EXCEEDS_MAXIMUM_CATEGORIES("Product cannot have more than three categories associated."),
    PRODUCT_HAS_DUPLICATE_CATEGORIES("Product cannot have duplicate categories associated."),
    PRODUCT_BRAND_IS_INVALID("Product brand does not exists."),
    PRODUCT_CATEGORY_INVALID("Product description cannot be blank."),
    CATEGORIES_NOT_FOUND("One or more categories with ids '%s' not found.");

    private final String message;

    ProductMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String formatMessage(Object... args) {
        return String.format(this.message, args);
    }
}
