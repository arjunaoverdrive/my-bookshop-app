package com.klimov.igor.BookShopApp.controllers;

import com.klimov.igor.BookShopApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SearchController {

    private final BookService bookService;

    @Autowired
    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

//    @ModelAttribute("searchResult")
//    private List<BookEntity>bookListByRegex(String regex){
//        return bookService.getBooksByRegExp(regex);
//    }
//
//
//    @GetMapping("/search/{regex}")
//    public String getSearchPage(@PathVariable("regex") String regex, Model model){
//        List<BookEntity>booksByRegexp = bookService.getBooksByRegExp(regex);
//        int resultSize = booksByRegexp.size();
//        model.addAttribute("resultSize", resultSize);
//        return "/search/index";
//    }
}
