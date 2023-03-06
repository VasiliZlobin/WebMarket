package ru.vasili_zlobin.web_market.carts.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vasili_zlobin.web_market.carts.model.Cart;

@Service
@RequiredArgsConstructor
public class CartService {
   private final Cart cart;

    public void change(Long id, Integer delta) {
        if (delta == 1) {
            cart.add(id);
        } else {
            cart.remove(id);
        }
    }

    public void delete(Long id) {
        cart.deleteAll(id);
    }

    public Integer getQuantity(Long id) {
        return cart.getQuantity(id);
    }
}
