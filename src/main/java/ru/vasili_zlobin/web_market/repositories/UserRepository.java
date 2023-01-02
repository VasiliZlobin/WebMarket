package ru.vasili_zlobin.web_market.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vasili_zlobin.web_market.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByName(String name);
}
