package com.klimov.igor.BookShopApp.model.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.klimov.igor.BookShopApp.model.author.AuthorEntity;
import com.klimov.igor.BookShopApp.model.book.file.BookFileEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
@ApiModel(description = "entity representing a book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id generated by db automatically")
    private Integer id;

    @Column(columnDefinition = "DATE NOT NULL", name = "pub_date")
    @ApiModelProperty("date of publication")
    private LocalDate publicationDate;

    @Column(columnDefinition = "INT NOT NULL", name = "is_bestseller")
    @ApiModelProperty("if isBestseller = 1, the book is considered to be a bestseller, otherwise, it's not a bestseller")
    private Integer isBestseller;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    @ApiModelProperty("mnemonic identifier")
    private String slug;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    @ApiModelProperty("book title")
    private String title;

    @Column(columnDefinition = "VARCHAR(255)")
    @ApiModelProperty("book cover")
    private String image;

    @Column(columnDefinition = "TEXT")
    @ApiModelProperty("description of the book")
    private String description;

    @Column(columnDefinition = "INT NOT NULL")
    @ApiModelProperty("price of the book")
    private Integer price;

    @Column(columnDefinition = "INT NOT NULL DEFAULT 0")
    @ApiModelProperty("discount")
    private int discount;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "book2author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private List<AuthorEntity> authorsList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "book_id", nullable = false)
    private List<BookFileEntity> bookFileList;

    public Integer getId() {
        return id;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer isBestseller() {
        return isBestseller;
    }

    public void setBestseller(Integer bestseller) {
        isBestseller = bestseller;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public List<AuthorEntity> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<AuthorEntity> authorsList) {
        this.authorsList = authorsList;
    }

    public List<BookFileEntity> getBookFileList() {
        return bookFileList;
    }

    public void setBookFileList(List<BookFileEntity> bookFileList) {
        this.bookFileList = bookFileList;
    }
}
