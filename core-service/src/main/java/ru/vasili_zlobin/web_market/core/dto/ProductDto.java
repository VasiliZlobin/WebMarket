package ru.vasili_zlobin.web_market.core.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vasili_zlobin.web_market.core.model.Product;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String title;
    private Double price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }
}
