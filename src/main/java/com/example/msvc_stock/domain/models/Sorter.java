package com.example.msvc_stock.domain.models;

import com.example.msvc_stock.infrastructure.util.enums.SorterDirection;

public class Sorter {
    private String field;
    private SorterDirection direction;

    public Sorter(String field, SorterDirection direction) {
        this.field = field;
        this.direction = direction;
    }

    public String getField() {
        return field;
    }

    public SorterDirection getDirection() {
        return direction;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setDirection(SorterDirection direction) {
        this.direction = direction;
    }
}
