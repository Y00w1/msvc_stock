package com.example.msvc_stock.domain.exceptions.brand;

import com.example.msvc_stock.domain.exceptions.DomainException;
import com.example.msvc_stock.domain.exceptions.constants.BrandMessages;

public class BrandNameTooLongException extends DomainException {
    public BrandNameTooLongException(String brandName) {
        super(BrandMessages.BRAND_NAME_TOO_LONG.formatMessage(brandName));
    }
}
