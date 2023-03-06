package ru.vasili_zlobin.web_market.carts.converters;

import org.springframework.stereotype.Component;
import ru.vasili_zlobin.web_market.api.dto.CartItemDto;
import ru.vasili_zlobin.web_market.api.dto.ProductDto;
import ru.vasili_zlobin.web_market.carts.model.CartItem;

import java.math.BigDecimal;

@Component
public class CartItemConverter {
    public CartItem productDtoToEntity(ProductDto dto) {
        CartItem item = new CartItem();
        item.setTitle(dto.getTitle());
        item.setPrice(dto.getPrice());
        item.setQuantity(0);
        item.setTotalCost(BigDecimal.ZERO);
        return item;
    }
    public CartItemDto entityToCartItemDto(CartItem item) {
        CartItemDto dto = new CartItemDto();
        dto.setId(item.getId());
        dto.setQuantity(item.getQuantity());
        dto.setPrice(item.getPrice());
        dto.setTitle(item.getTitle());
        dto.setTotalCost(item.getTotalCost());
        return dto;
    }
}
