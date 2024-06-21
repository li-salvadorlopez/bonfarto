package com.azteklabs.doctorservice.domain.model;

public class PageRequest {
    private final int page;
    private final int size;

    public PageRequest(int page, int size) {
        if (page < 0){
            throw new IllegalArgumentException("Page must be greater than 0");
        }
        if (size < 1){
            throw new IllegalArgumentException("Page size must not be less than one");
        }
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
