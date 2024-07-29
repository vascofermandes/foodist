package pt.tecnico.foodist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.tecnico.foodist.model.FoodService;

import java.util.List;

@Repository
public interface FoodServiceRepository extends JpaRepository<FoodService, Long> {
    List<FoodService> findByCampus(String campus);
}
