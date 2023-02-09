package ru.vasili_zlobin.web_market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.vasili_zlobin.web_market.core.converters.ProductConverter;
import ru.vasili_zlobin.web_market.core.model.Product;
import ru.vasili_zlobin.web_market.core.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private static final long MIN_RECORDS = 100L;
    private static final int PAGE_SIZE = 10;

    private final ProductRepository repository;
    private final ProductConverter productConverter;

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabase() {
        Long count = MIN_RECORDS - repository.count();
        for (int i = 1; i <= count ; i++) {
            repository.save(new Product(String.format("Товар № %d", i), Math.random() * 100));
        }
    }

    public Page<Product> find(Integer pageNumber) {
        return repository.findAll(PageRequest.of(pageNumber - 1, PAGE_SIZE));
    }

    public List<Product> getProductsList() {
        return repository.findAll();
    }
}
