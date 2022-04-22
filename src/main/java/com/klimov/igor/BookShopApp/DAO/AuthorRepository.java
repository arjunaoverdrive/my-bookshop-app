package com.klimov.igor.BookShopApp.DAO;

import com.klimov.igor.BookShopApp.data.author.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
    AuthorEntity findById(int id);
}
