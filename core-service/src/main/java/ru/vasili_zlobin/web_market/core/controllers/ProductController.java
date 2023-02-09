package ru.vasili_zlobin.web_market.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vasili_zlobin.web_market.core.converters.ProductConverter;
import ru.vasili_zlobin.web_market.core.dto.ProductDto;
import ru.vasili_zlobin.web_market.core.services.ProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductService productService;
    private final ProductConverter productConverter;

    @GetMapping("/products")
    public Page<ProductDto> getListProducts(@RequestParam(defaultValue = "1") Integer pageNumber) {
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        return productService.find(pageNumber).map(productConverter::entityToDto);
    }

}
