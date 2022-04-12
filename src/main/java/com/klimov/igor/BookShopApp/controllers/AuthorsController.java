package com.klimov.igor.BookShopApp.controllers;

import com.klimov.igor.BookShopApp.data.Author;
import com.klimov.igor.BookShopApp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AuthorsController {

    private final AuthorService authorService;

    @Autowired
    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> getAuthors(){
        Map<String, List<Author>> authorsMap = authorService.getAuthorsMap();
        return authorsMap;
    }


    @GetMapping("/authors")
    public String authorsPage(){
        return "/authors/index";
    }
}
