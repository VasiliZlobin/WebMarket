package ru.vasili_zlobin.web_market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasili_zlobin.web_market.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
