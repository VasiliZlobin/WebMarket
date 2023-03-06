package ru.vasili_zlobin.web_market.carts.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vasili_zlobin.web_market.api.dto.ProductDto;
import ru.vasili_zlobin.web_market.carts.services.CartService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CartController {
    private final CartService cartService;

    @GetMapping("/product")
    public Integer getProductQuantity(@RequestParam String cartKey, @RequestParam Long id) {
        return cartService.getQuantity(cartKey, id);
    }

    @PostMapping("/change_quantity")
    public Integer changeQuantity(@RequestParam String cartKey, @RequestParam ProductDto productDto, @RequestParam Integer delta) {
        cartService.change(cartKey, productDto, delta);
        return cartService.getQuantity(cartKey, productDto.getId());
    }
}
