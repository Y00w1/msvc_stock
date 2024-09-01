package com.example.msvc_stock.domain.models;

import com.example.msvc_stock.infrastructure.util.enums.SorterDirection;

public class Sorter {
    private String field;
    private SorterDirection sorterDirection;

    public Sorter(String field, SorterDirection sorterDirection) {
        this.field = field;
        this.sorterDirection = sorterDirection;
    }

    public String getField() {
        return field;
    }

    public SorterDirection getSorterDirection() {
        return sorterDirection;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setSorterDirection(SorterDirection sorterDirection) {
        this.sorterDirection = sorterDirection;
    }
}
