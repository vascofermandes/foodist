package pt.tecnico.foodist.service;

import pt.tecnico.foodist.model.DishPhoto;

import java.util.List;
import java.util.Optional;

public interface DishPhotoService {

    List<DishPhoto> findAll();

    Optional<DishPhoto> findById(Long id);

    DishPhoto save(DishPhoto dish);

}
