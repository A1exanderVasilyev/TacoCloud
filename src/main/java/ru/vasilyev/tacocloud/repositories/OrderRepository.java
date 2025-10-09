package ru.vasilyev.tacocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vasilyev.tacocloud.tacos.TacoOrder;

public interface OrderRepository
        extends CrudRepository<TacoOrder, Long> {
}
