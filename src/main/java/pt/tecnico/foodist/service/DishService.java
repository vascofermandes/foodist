package pt.tecnico.foodist.service;

import pt.tecnico.foodist.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {

    List<Dish> findAll();

    Optional<Dish> findById(Long id);

    Dish create(Dish dish);

}
