package com.klimov.igor.BookShopApp.controllers;

import com.klimov.igor.BookShopApp.data.Book;
import com.klimov.igor.BookShopApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    private final BookService bookService;

    @Autowired
    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("searchResult")
    private List<Book>bookListByRegex(String regex){
        return bookService.getBooksByRegExp(regex);
    }


    @GetMapping("/search/{regex}")
    public String getSearchPage(@PathVariable("regex") String regex, Model model){
        List<Book>booksByRegexp = bookService.getBooksByRegExp(regex);
        int resultSize = booksByRegexp.size();
        model.addAttribute("resultSize", resultSize);
        return "/search/index";
    }
}
