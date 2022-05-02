package com.klimov.igor.BookShopApp.DAO;

import com.klimov.igor.BookShopApp.model.book.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    Optional<BookEntity> findBookByTitle(String title);

    List<BookEntity> findBooksByAuthorsListContaining(String name);

    List<BookEntity>findBooksByTitleContaining(String bookTitle);

    List<BookEntity>findBooksByPriceBetween(Integer min, Integer max);

    List<BookEntity> findBooksByPriceIs(Integer price);

    @Query("from BookEntity where isBestseller=1")
    List<BookEntity> getBestsellers();

    @Query(value = "SELECT * FROM books WHERE discount = (SELECT MAX(discount) FROM books)", nativeQuery = true)
    List<BookEntity> getBookWithMaxDiscount();

    Page<BookEntity> findBooksByTitleContaining(String bookTitle, Pageable nextPage);

}
