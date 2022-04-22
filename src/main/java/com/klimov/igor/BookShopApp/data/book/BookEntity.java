package com.klimov.igor.BookShopApp.data.book;

import com.klimov.igor.BookShopApp.data.author.AuthorEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "DATE NOT NULL", name = "pub_date")
    private LocalDate publicationDate;

    @Column(columnDefinition = "INT NOT NULL", name = "is_bestseller")
    private boolean isBestseller;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String slug;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String title;

    @Column(columnDefinition = "VARCHAR(255)")
    private String image;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "INT NOT NULL")
    private Integer price;

    @Column(columnDefinition = "INT NOT NULL DEFAULT 0")
    private int discount;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "book2author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private List<AuthorEntity> authorsList;

    public Integer getId() {
        return id;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public boolean isBestseller() {
        return isBestseller;
    }

    public void setBestseller(boolean bestseller) {
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

    //    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "author_id", referencedColumnName = "id")
//    private AuthorEntity author;
//
//    public String getTitle() {
//        return title;
//    }
//
//    public AuthorEntity getAuthorEntity() {
//        return author;
//    }
//
//    public void setAuthorEntity(AuthorEntity author) {
//        this.author = author;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public BigDecimal getPriceOld() {
//        return priceOld;
//    }
//
//    public void setPriceOld(BigDecimal priceOld) {
//        this.priceOld = priceOld;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }

}
