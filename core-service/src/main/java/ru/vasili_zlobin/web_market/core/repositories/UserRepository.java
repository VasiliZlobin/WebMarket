package ru.vasili_zlobin.web_market.core.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vasili_zlobin.web_market.core.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByName(String name);
}
