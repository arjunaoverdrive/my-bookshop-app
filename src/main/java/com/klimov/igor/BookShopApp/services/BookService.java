package com.klimov.igor.BookShopApp.services;

import com.klimov.igor.BookShopApp.DAO.BookRepository;
import com.klimov.igor.BookShopApp.model.book.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
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

    public List<BookEntity> getBooksByTitle(String title){
        return bookRepository.findBooksByTitleContaining(title);
    }

    public List<BookEntity> getBooksWithPriceBetween(Integer min, Integer max){
        return bookRepository.findBooksByPriceBetween(min, max);
    }

    public List<BookEntity> getBooksWithPrice(Integer price){
        return bookRepository.findBooksByPriceIs(price);
    }

    public List<BookEntity> getWithMaxDiscount(){
        return bookRepository.getBookWithMaxDiscount();
    }

    public List<BookEntity> getBestsellers(){
        return bookRepository.getBestsellers();
    }

    public Page<BookEntity> getPageOfRecommendedBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findAll(nextPage);
    }

    public Page<BookEntity> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findBooksByTitleContaining(searchWord, nextPage);
    }
}
