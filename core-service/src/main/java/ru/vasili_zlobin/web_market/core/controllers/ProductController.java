package ru.vasili_zlobin.web_market.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vasili_zlobin.web_market.core.services.ProductService;
import ru.vasili_zlobin.web_market.core.dto.ProductDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductService service;

    @GetMapping("/products")
    public Page<ProductDto> getListProducts(@RequestParam(defaultValue = "1") Integer pageNumber) {
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        return service.find(pageNumber).map(ProductDto::new);
    }
}
