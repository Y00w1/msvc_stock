package com.example.msvc_stock.domain.models;

import java.util.List;

public class Paged<T> {
    List<T> items;
    int page;
    int totalElements;
    int totalPages;

    public Paged(int totalPages, int totalElements, int page, List<T> items) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
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

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
