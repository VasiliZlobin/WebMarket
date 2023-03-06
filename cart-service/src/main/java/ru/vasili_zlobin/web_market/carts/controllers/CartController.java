package ru.vasili_zlobin.web_market.carts.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vasili_zlobin.web_market.carts.services.CartService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CartController {
    private final CartService cartService;

    @GetMapping("/product")
    public Integer getProductQuantity(@RequestParam Long id) {
        return cartService.getQuantity(id);
    }

    @GetMapping("/change_quantity")
    public Integer changeQuantity(@RequestParam Long id, @RequestParam Integer delta) {
        cartService.change(id, delta);
        return cartService.getQuantity(id);
    }
}
