package ru.vasili_zlobin.web_market.core.converters;

import org.springframework.stereotype.Component;
import ru.vasili_zlobin.web_market.core.model.Product;
import ru.vasili_zlobin.web_market.api.dto.ProductDto;

@Component
public class ProductConverter {
    public ProductDto entityToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        return dto;
    }

    public Product dtoToEntity(ProductDto dto) {
        Product product = new Product();
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        return product;
    }
}
