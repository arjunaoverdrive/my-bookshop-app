package com.klimov.igor.BookShopApp.controllers;

import com.klimov.igor.BookShopApp.data.author.AuthorEntity;
import com.klimov.igor.BookShopApp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
    public Map<String, List<AuthorEntity>> getAuthors(){
        Map<String, List<AuthorEntity>> authorsMap = authorService.getAuthorsMap();
        return authorsMap;
    }


    @GetMapping("/authors")
    public String authorsPage(){
        return "/authors/index";
    }
}
