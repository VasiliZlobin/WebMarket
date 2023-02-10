package ru.vasili_zlobin.web_market.api.dto;

import java.math.BigDecimal;

public class CartItem {
    private Long id;
    private String title;
    private int quantity;
    private BigDecimal price;
    private BigDecimal totalCost;

    public CartItem(Long id, String title, int quantity, BigDecimal price, BigDecimal totalCost) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.totalCost = totalCost;
    }

    public CartItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
}
