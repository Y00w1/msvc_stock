package com.example.msvc_stock.domain.models;

import java.util.List;

public class Paged<T> {
    List<T> items;
    int page;
    int size;
    int total;

    public Paged(int total, int size, int page, List<T> items) {
        this.total = total;
        this.size = size;
        this.page = page;
        this.items = items;
    }

    public Paged() {
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
