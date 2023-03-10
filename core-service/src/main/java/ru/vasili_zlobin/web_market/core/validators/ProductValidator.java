package ru.vasili_zlobin.web_market.core.validators;

import org.springframework.stereotype.Component;
import ru.vasili_zlobin.web_market.api.dto.ProductDto;
import ru.vasili_zlobin.web_market.api.exceptions.ValidateException;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Component
public class ProductValidator {
    public void validate(ProductDto dto) {
        List<String> errors = new LinkedList<>();
        if (dto.getPrice().compareTo(BigDecimal.ZERO) != 1) {
            errors.add("Цена должна быть больше 0!");
        }
        if (dto.getTitle().isBlank()) {
            errors.add("Требуется указать наименование товара!");
        }
        if (!errors.isEmpty()) {
            throw new ValidateException(errors);
        }
    }
}
