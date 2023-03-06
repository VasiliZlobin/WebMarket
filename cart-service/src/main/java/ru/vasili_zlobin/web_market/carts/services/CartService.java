package ru.vasili_zlobin.web_market.carts.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vasili_zlobin.web_market.api.dto.ProductDto;
import ru.vasili_zlobin.web_market.carts.model.Cart;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CartService {
   private final HashMap<String, Cart> carts;

    public void change(String key, ProductDto productDto, Integer delta) {
        Cart cart = carts.get(key);
        if (delta == 1) {
            cart.add(productDto);
        } else {
            cart.remove(productDto.getId());
        }
    }

    public void delete(String key, Long id) {
    }

    public Integer getQuantity(String key, Long id) {
        if (carts.containsKey(key)) {
            return carts.get(key).getQuantity(id);
        }
        return 0;
    }
}
