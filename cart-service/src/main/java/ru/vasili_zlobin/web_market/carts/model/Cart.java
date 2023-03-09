package ru.vasili_zlobin.web_market.carts.model;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.vasili_zlobin.web_market.api.dto.ProductDto;
import ru.vasili_zlobin.web_market.carts.converters.CartItemConverter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class Cart {
    private Map<Long, CartItem> goods = new HashMap<>();
    private final CartItemConverter cartItemConverter;


    private void calculateTotalCost(CartItem item) {
        item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
    }
    public void add(ProductDto productDto) {
        int quantity = 0;
        Long id = productDto.getId();
        if (!goods.containsKey(id)) {
            goods.put(id, cartItemConverter.productDtoToEntity(productDto));
        }
        CartItem item = goods.get(id);
        item.setQuantity(item.getQuantity() + 1);
        calculateTotalCost(item);
    }

    public void remove(Long id) {
        if (!goods.containsKey(id)) {
            return;
        }
        CartItem item = goods.get(id);
        int quantity = item.getQuantity();
        if (quantity < 2) {
            goods.remove(id);
        } else {
            item.setQuantity(quantity - 1);
            calculateTotalCost(item);
        }
    }

    public void deleteAll(Long id) {
        if (goods.containsKey(id)) {
            goods.remove(id);
        }
    }

    public Integer getQuantity(Long id) {
        Integer result = 0;
        if (goods.containsKey(id)) {
            result = goods.get(id).getQuantity();
        }
        return result;
    }
}
