package com.klimov.igor.BookShopApp.DTO;

public class BookDto {
    private String title;
    private Integer price;
    private Integer discount;

    public BookDto() {
    }

    public BookDto(String title, Integer price, Integer discount) {
        this.title = title;
        this.price = price;
        this.discount = discount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
