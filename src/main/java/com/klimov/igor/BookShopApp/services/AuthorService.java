package com.klimov.igor.BookShopApp.services;

import com.klimov.igor.BookShopApp.data.Author;
import com.klimov.igor.BookShopApp.data.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, List<Author>> getAuthorsMap() {
        List<Author>authors = jdbcTemplate.query("SELECT * FROM Authors", (ResultSet rs, int rowNums) -> {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            return author;
        });
        return authors.stream()
                .collect(Collectors.groupingBy((Author a) -> {return a.getLastName().substring(0, 1);}));
    }
}
