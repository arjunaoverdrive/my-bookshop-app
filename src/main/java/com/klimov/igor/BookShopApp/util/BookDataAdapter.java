package com.klimov.igor.BookShopApp.util;

import com.klimov.igor.BookShopApp.DAO.BookRepository;
import com.klimov.igor.BookShopApp.DTO.BookDto;
import com.klimov.igor.BookShopApp.model.book.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class BookDataAdapter {

    private final BookRepository repository;

    @Autowired
    public BookDataAdapter(BookRepository repository) {
        this.repository = repository;
    }

    public BookEntity convertFromDtoToEntity(BookDto bookDto){
        BookEntity bookEntity = repository.findBookByTitle(bookDto.getTitle())
                .orElseThrow(()-> new NullPointerException("Book: " + bookDto.getTitle() +  "not found"));
        return bookEntity;
    }

    public BookDto convertFromEntityToDto(BookEntity book){
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setBestseller(book.isBestseller());
        dto.setImage(book.getImage());
        dto.setSlug(book.getSlug());
        dto.setPrice(book.getPrice());
        dto.setAuthors(book.getAuthorsList()); //todo implement correct display if there are a few
        dto.setDiscountPrice(calculateDiscountPrice(book));
        dto.setRating(calculateRating(book));
        dto.setStatus(getStatus(book));
        return dto;
    }

    private Integer calculateDiscountPrice(BookEntity book){
        int discountPrice = book.getPrice() - (int)((book.getPrice() * book.getDiscount()) / 100);
        return discountPrice;
    }

    private String getStatus(BookEntity book){
        return "false"; //todo implement correct status retrieval
    }

    private Integer calculateRating(BookEntity book){
        return (int)(Math.random() * 1000) % 5 ; //todo implement correct rating computation
    }
}
