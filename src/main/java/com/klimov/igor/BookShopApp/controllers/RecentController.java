package com.klimov.igor.BookShopApp.controllers;

import com.klimov.igor.BookShopApp.data.book.BookEntity;
import com.klimov.igor.BookShopApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class RecentController {
    private final BookService bookService;

    @ModelAttribute("recent")
    public List<BookEntity>getRecent(){
        return bookService.getRecentList();
    }

    @Autowired
    public RecentController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/recent")
    public String recentPage(){
        return "/books/recent";
    }

}
