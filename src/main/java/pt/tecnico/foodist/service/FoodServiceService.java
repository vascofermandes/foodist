package pt.tecnico.foodist.service;

import pt.tecnico.foodist.model.FoodService;

import java.util.List;
import java.util.Optional;

public interface FoodServiceService {

    List<FoodService> findAll();

    Optional<FoodService> findById(Long id);

    List<FoodService> findByCampus(String campus);

    FoodService create(FoodService foodService);
}
