package com.klimov.igor.BookShopApp.services;

import com.klimov.igor.BookShopApp.model.book.BookEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api
public class BooksRestApiController {

    private final BookService bookService;

    @Autowired
    public BooksRestApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/by-title")
    @ApiOperation("operation to get book list by title")
    public ResponseEntity<List<BookEntity>>booksByTitle(@RequestParam("title") String title){
        return ResponseEntity.ok(bookService.getBooksByTitle(title));
    }

    @GetMapping("/books/by-price-range")
    @ApiOperation("operation to get books between min and max price parameters")
    public ResponseEntity<List<BookEntity>> priceRangeBooks(@RequestParam("min")Integer min,
                                                            @RequestParam("max") Integer max){
        return ResponseEntity.ok(bookService.getBooksWithPriceBetween(min, max));
    }

    @GetMapping("/books/with-max-discount")
    @ApiOperation("get book with max discount")
    public ResponseEntity<List<BookEntity>> minPriceBooks(){
        return ResponseEntity.ok(bookService.getWithMaxDiscount());
    }

    @GetMapping("/books/bestsellers")
    @ApiOperation("get list of bestsellers")
    public ResponseEntity<List<BookEntity>> bestsellers(){
        return ResponseEntity.ok(bookService.getBestsellers());
    }
}
