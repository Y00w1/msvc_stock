package com.example.msvc_stock.domain.models;

public class Pagination {
    private int page;
    private int size;

    public Pagination(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }
}
