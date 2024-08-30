package com.example.msvc_stock.domain.exceptions.brand;

import com.example.msvc_stock.domain.exceptions.DomainException;
import com.example.msvc_stock.domain.exceptions.constants.BrandMessages;

public class BrandAlreadyExistsException extends DomainException {
    public BrandAlreadyExistsException(String brandName) {
        super(BrandMessages.BRAND_ALREADY_EXISTS.formatMessage(brandName));
    }
}
