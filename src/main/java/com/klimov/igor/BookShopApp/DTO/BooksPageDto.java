package com.klimov.igor.BookShopApp.DTO;

import com.klimov.igor.BookShopApp.model.book.BookEntity;

import java.util.List;

public class BooksPageDto {
    private Integer count;
    private List<BookEntity> books;

    public BooksPageDto(List<BookEntity> books) {
        this.count = books.size();
        this.books = books;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
}
