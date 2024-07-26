package pt.tecnico.foodist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.tecnico.foodist.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
}
