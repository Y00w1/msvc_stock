package com.example.msvc_stock.domain.exceptions.brand;

import com.example.msvc_stock.domain.exceptions.DomainException;
import com.example.msvc_stock.domain.exceptions.constants.BrandMessages;

public class BrandDescriptionTooLongException extends DomainException {
    public BrandDescriptionTooLongException(String brandDescription) {
        super(BrandMessages.BRAND_DESCRIPTION_TOO_LONG.formatMessage(brandDescription));
    }
}
