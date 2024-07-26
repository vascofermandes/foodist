package pt.tecnico.foodist.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.tecnico.foodist.model.FoodService;
import pt.tecnico.foodist.repository.FoodServiceRepository;
import pt.tecnico.foodist.service.FoodServiceService;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class FoodServiceServiceImp implements FoodServiceService {

    @Autowired
    FoodServiceRepository foodServiceRepository;
    private final Logger logger = Logger.getLogger(FoodServiceServiceImp.class.getName());

    @Override
    public List<FoodService> findAll() {
        logger.info("Finding all the dishes");
        return foodServiceRepository.findAll();
    }

    @Override
    public Optional<FoodService> findById(Long id) {
        logger.info("Finding FoodService " + id);
        return foodServiceRepository.findById(id);
    }

    @Override
    public FoodService create(FoodService foodService) {
        logger.info("Create a FoodService " + foodService.getName());
        return foodServiceRepository.save(foodService);
    }
}
