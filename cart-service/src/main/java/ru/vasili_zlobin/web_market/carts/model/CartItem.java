package ru.vasili_zlobin.web_market.carts.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
public class CartItem {
    private Long id;
    private String title;
    private int quantity;
    private BigDecimal price;
    private BigDecimal totalCost;

    public BigDecimal getDiscount() {
        return totalCost.subtract(price.multiply(BigDecimal.valueOf(quantity)));
    }
}
