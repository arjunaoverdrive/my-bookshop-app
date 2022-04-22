package com.klimov.igor.BookShopApp.DAO;

import com.klimov.igor.BookShopApp.data.book.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findBooksByAuthorsListContaining(String name);
}
