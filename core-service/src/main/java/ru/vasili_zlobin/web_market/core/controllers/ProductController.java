package ru.vasili_zlobin.web_market.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.vasili_zlobin.web_market.api.dto.ProductDto;
import ru.vasili_zlobin.web_market.core.converters.ProductConverter;
import ru.vasili_zlobin.web_market.core.model.Product;
import ru.vasili_zlobin.web_market.core.services.ProductService;
import ru.vasili_zlobin.web_market.core.validators.ProductValidator;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductService productService;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    @GetMapping("/products")
    public Page<ProductDto> getListProducts(@RequestParam(defaultValue = "1") Integer pageNumber) {
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        return productService.find(pageNumber).map(productConverter::entityToDto);
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id) {

        return productConverter.entityToDto(productService.getProductById(id));
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDto dto) {
        productValidator.validate(dto);
        productService.updateProduct(new Product(dto.getTitle(), dto.getPrice()));
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDto dto) {
        productValidator.validate(dto);
        Product product = productService.getProductById(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
