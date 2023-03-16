package ru.vasili_zlobin.web_market.carts.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vasili_zlobin.web_market.api.dto.CartDto;
import ru.vasili_zlobin.web_market.carts.model.Cart;

@Component
@RequiredArgsConstructor
public class CartConverter {
    private final CartItemConverter cartItemConverter;
    public Cart dtoToEntity(CartDto dto) {
        Cart cart = new Cart();
        dto.getItems().stream()
                .map(cartItemDto -> cartItemConverter.cartItemDtoToEntity(cartItemDto))
                .forEach(cart::add);
        return cart;
    }
}
