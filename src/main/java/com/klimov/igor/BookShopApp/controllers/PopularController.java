package com.klimov.igor.BookShopApp.controllers;

import com.klimov.igor.BookShopApp.model.book.BookEntity;
import com.klimov.igor.BookShopApp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class PopularController {

    private final BookService bookService;

    public PopularController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("popular")
    public List<BookEntity> getPopular(){
        return bookService.getBooksData();
    }

    @GetMapping("/books/popular")
    public String popularPage(){
        return "/books/popular";
    }
}
