package com.klimov.igor.BookShopApp.controllers;

import com.klimov.igor.BookShopApp.data.book.BookEntity;
import com.klimov.igor.BookShopApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<BookEntity> recommendedBooks(){
        return bookService.getBooksData();
    }

    @ModelAttribute("recentBooks")
    public List<BookEntity> recentBooks() {return bookService.getRecentList(); }

    @ModelAttribute("popularBooks")
    public List<BookEntity> getPopular(){
        return bookService.getBooksData();
    }


    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

}
