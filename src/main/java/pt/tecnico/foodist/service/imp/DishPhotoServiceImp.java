package pt.tecnico.foodist.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.tecnico.foodist.model.DishPhoto;
import pt.tecnico.foodist.repository.DishPhotoRepository;
import pt.tecnico.foodist.service.DishPhotoService;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class DishPhotoServiceImp implements DishPhotoService {

    private final Logger logger = Logger.getLogger(DishPhotoServiceImp.class.getName());

    @Autowired
    DishPhotoRepository dishPhotoRepository;

    @Override
    public List<DishPhoto> findAll() {
        logger.info("Finding all the dishes");
        return dishPhotoRepository.findAll();
    }

    @Override
    public Optional<DishPhoto> findById(Long id) {
        logger.info("Finding dish " + id);
        return dishPhotoRepository.findById(id);
    }

    @Override
    public DishPhoto save(DishPhoto dishPhoto) {
        logger.info("Creating dish " + dishPhoto.toString());
        return dishPhotoRepository.save(dishPhoto);
    }


}
