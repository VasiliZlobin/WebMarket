package ru.vasili_zlobin.web_market.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vasili_zlobin.web_market.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
