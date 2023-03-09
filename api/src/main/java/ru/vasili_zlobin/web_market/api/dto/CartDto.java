package ru.vasili_zlobin.web_market.api.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartDto {
    private List<CartItemDto> items = new ArrayList<>();
    private BigDecimal totalCost;

    public CartDto() {
    }

    public List<CartItemDto> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void setItems(List<CartItemDto> items) {
        this.items = items;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
}
