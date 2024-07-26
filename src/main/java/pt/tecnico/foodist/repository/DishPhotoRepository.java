package pt.tecnico.foodist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.tecnico.foodist.model.Dish;
import pt.tecnico.foodist.model.DishPhoto;

@Repository
public interface DishPhotoRepository extends JpaRepository<DishPhoto, Long> {
}
