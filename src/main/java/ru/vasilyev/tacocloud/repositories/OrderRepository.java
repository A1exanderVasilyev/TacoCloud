package ru.vasilyev.tacocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vasilyev.tacocloud.tacos.TacoOrder;
import ru.vasilyev.tacocloud.tacos.User;

import java.util.Optional;

public interface OrderRepository
        extends CrudRepository<TacoOrder, Long> {
    Optional<TacoOrder> findTacoOrderByUser(User user);
}
