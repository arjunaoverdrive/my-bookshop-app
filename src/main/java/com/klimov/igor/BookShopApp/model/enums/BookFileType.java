package com.klimov.igor.BookShopApp.model.enums;

public enum BookFileType {
    PDF(0),
    EPUB(1),
    FB2(2);

    private final Integer id;

    BookFileType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
