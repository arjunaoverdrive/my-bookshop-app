package com.klimov.igor.BookShopApp.model.book.file;

import com.klimov.igor.BookShopApp.model.enums.BookFileType;

import javax.persistence.*;

@Entity
@Table(name = "book_file_type")
public class BookFileTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private BookFileType name;

    @Transient
    private Integer typeId;

    @Column(columnDefinition = "TEXT")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookFileType getName() {
        return name;
    }

    public void setName(BookFileType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTypeId() {
        return name.getId();
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
