package com.klimov.igor.BookShopApp.services;

import com.klimov.igor.BookShopApp.DAO.AuthorRepository;
import com.klimov.igor.BookShopApp.DAO.BookRepository;
import com.klimov.igor.BookShopApp.data.book.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getBooksData(){
        return bookRepository.findAll();
    }

    public List<BookEntity> getRecentList() {
        List<BookEntity>books = getBooksData()
                .stream()
                .sorted(Comparator.comparing(BookEntity::getPublicationDate))
                .collect(Collectors.toList());
        return books;
    }

    public List<BookEntity> getBooksByAuthor(String name){
        List<BookEntity> books = bookRepository.findBooksByAuthorsListContaining(name);
        return books;
    }
}
