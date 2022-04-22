package com.klimov.igor.BookShopApp.services;

import com.klimov.igor.BookShopApp.DAO.AuthorRepository;
import com.klimov.igor.BookShopApp.data.author.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Map<String, List<AuthorEntity>> getAuthorsMap() {
        List<AuthorEntity>authors = authorRepository.findAll();
        return authors.stream()
                .collect(Collectors.groupingBy((AuthorEntity a) -> {return a.getName().substring(0, 1);}));
    }
}
