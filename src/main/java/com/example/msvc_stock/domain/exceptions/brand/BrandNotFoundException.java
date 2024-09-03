package com.example.msvc_stock.domain.exceptions.brand;

import com.example.msvc_stock.domain.exceptions.DomainException;
import com.example.msvc_stock.domain.exceptions.constants.BrandMessages;

public class BrandNotFoundException extends DomainException {
    public BrandNotFoundException(Long id) {
        super(BrandMessages.BRAND_NOT_FOUND.formatMessage(id));
    }
}
