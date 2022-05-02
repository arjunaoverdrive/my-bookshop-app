package com.klimov.igor.BookShopApp.controllers;

import com.klimov.igor.BookShopApp.DTO.BooksPageDto;
import com.klimov.igor.BookShopApp.DTO.SearchWordDto;
import com.klimov.igor.BookShopApp.model.book.BookEntity;
import com.klimov.igor.BookShopApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        return bookService.getPageOfRecommendedBooks(0, 6).getContent();
    }

    @ModelAttribute("recentBooks")
    public List<BookEntity> recentBooks() {return bookService.getRecentList(); }

    @ModelAttribute("popularBooks")
    public List<BookEntity> getPopular(){
        return bookService.getBooksData();
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }

    @ModelAttribute("searchResults")
    public List<BookEntity>searchResults(){
        return new ArrayList<>();
    }

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

    @GetMapping("/books/recommended")
    @ResponseBody
    public BooksPageDto getBooksPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        Page<BookEntity> pageOfRecommendedBooks = bookService.getPageOfRecommendedBooks(offset, limit);
        return new BooksPageDto(pageOfRecommendedBooks.getContent());
    }

    @GetMapping(value = {"/search", "search/{searchWord}"})
    public String getSearchResults(@PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto, Model model){
        model.addAttribute("searchWordDto", searchWordDto);
        model.addAttribute("searchResults", bookService.getPageOfSearchResultBooks(searchWordDto.getExample(), 0, 5).getContent());
        model.addAttribute("resultSize", bookService.getBooksByTitle(searchWordDto.getExample()).size());
        return "/search/index";
    }

    @GetMapping("/search/page/{searchWord}")
    @ResponseBody
    public BooksPageDto getNextSearchPage(@PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto,
                                         @RequestParam(value = "offset") Integer offset,
                                         @RequestParam(value = "limit") Integer limit){
        return new BooksPageDto(bookService.getPageOfSearchResultBooks(searchWordDto.getExample(), offset, limit).getContent());
    }

}
