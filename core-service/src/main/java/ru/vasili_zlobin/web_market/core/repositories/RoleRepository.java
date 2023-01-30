package ru.vasili_zlobin.web_market.core.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vasili_zlobin.web_market.core.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
