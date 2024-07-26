package pt.tecnico.foodist.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.tecnico.foodist.model.Dish;
import pt.tecnico.foodist.repository.DishRepository;
import pt.tecnico.foodist.service.DishService;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class DishServiceImp implements DishService {

    private final Logger logger = Logger.getLogger(DishServiceImp.class.getName());

    @Autowired
    DishRepository dishRepository;

    @Override
    public List<Dish> findAll() {
        logger.info("Finding all the dishes");
        return dishRepository.findAll();
    }

    @Override
    public Optional<Dish> findById(Long id) {
        logger.info("Finding dish " + id);
        return dishRepository.findById(id);
    }

    @Override
    public Dish save(Dish dish) {
        logger.info("Creating dish " + dish.getName() + " number of photos " + dish.getPhotos().size());
        return dishRepository.save(dish);
    }


}
