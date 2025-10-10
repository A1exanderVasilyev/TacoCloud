package ru.vasilyev.tacocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vasilyev.tacocloud.tacos.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
