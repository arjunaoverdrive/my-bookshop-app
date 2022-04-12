package com.klimov.igor.BookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class GenresController {

    @GetMapping("/genres")
    public String genresPage(){
        return "/genres/index";
    }
}
