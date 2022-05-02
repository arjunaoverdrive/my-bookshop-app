package com.klimov.igor.BookShopApp.model.book.links;

import com.klimov.igor.BookShopApp.model.enums.BookRelationType;

import javax.persistence.*;

@Entity
@Table(name = "book2user_type")
public class Book2UserTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private BookRelationType name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BookRelationType getName() {
        return name;
    }

    public void setName(BookRelationType name) {
        this.name = name;
    }
}
