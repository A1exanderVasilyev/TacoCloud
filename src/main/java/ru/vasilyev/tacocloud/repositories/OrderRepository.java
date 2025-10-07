package ru.vasilyev.tacocloud.repositories;

import ru.vasilyev.tacocloud.tacos.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
