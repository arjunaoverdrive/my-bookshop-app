package com.klimov.igor.BookShopApp.services;

import com.klimov.igor.BookShopApp.data.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooksData(){
        List<Book>books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int rowNums) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));
            book.setPrice(rs.getBigDecimal("price"));
            book.setPriceOld(rs.getBigDecimal("priceOld"));
            return book;
        });
        return new ArrayList<>(books);
    }

    public List<Book> getRecentList() {
        List<Book>books = getBooksData();
        return books;
    }


    public List<Book> getBooksByRegExp(String regexp) {
        List<Book>books = jdbcTemplate.query("SELECT * FROM books WHERE title LIKE '%" + regexp + "%' OR author LIKE '%" +
                regexp + "%' ORDER BY title", (ResultSet rs, int rowNums) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));
            book.setPrice(rs.getBigDecimal("price"));
            book.setPriceOld(rs.getBigDecimal("priceOld"));
            return book;
        });
        return new ArrayList<>(books);
    }
}
