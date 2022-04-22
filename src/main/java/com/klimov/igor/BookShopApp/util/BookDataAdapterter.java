package com.klimov.igor.BookShopApp.util;

import com.klimov.igor.BookShopApp.DAO.BookRepository;
import com.klimov.igor.BookShopApp.DTO.BookDto;
import com.klimov.igor.BookShopApp.data.book.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class BookDataAdapterter {

    private final BookRepository repository;

    @Autowired
    public BookDataAdapterter(BookRepository repository) {
        this.repository = repository;
    }

    public BookEntity convertFromDtoToEntity(BookDto bookDto){
        BookEntity bookEntity = repository.findBookByTitle(bookDto.getTitle())
                .orElseThrow(()-> new NullPointerException("Book: " + bookDto.getTitle() +  "not found"));
        return bookEntity;
    }

    public BookDto convertFromEntityToDto(BookEntity book){
        BookDto bookDto = new BookDto(book.getTitle(), book.getPrice(), book.getDiscount());
        return bookDto;
    }
}
