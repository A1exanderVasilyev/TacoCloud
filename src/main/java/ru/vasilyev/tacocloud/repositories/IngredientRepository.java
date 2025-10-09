package ru.vasilyev.tacocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vasilyev.tacocloud.tacos.Ingredient;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {
}
