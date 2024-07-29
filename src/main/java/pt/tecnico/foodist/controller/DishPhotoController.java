package pt.tecnico.foodist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pt.tecnico.foodist.model.Dish;
import pt.tecnico.foodist.model.DishPhoto;
import pt.tecnico.foodist.service.DishPhotoService;
import pt.tecnico.foodist.service.DishService;
import pt.tecnico.foodist.utils.FileStorageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dishPhotos")
public class DishPhotoController {

    @Autowired
    private DishService dishService;

    @Autowired
    private DishPhotoService dishPhotoService;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping()
    public List<DishPhoto> findAll(){
        return dishPhotoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DishPhoto> findById(@PathVariable(value = "id") Long id){
        return dishPhotoService.findById(id);
    }

    @PostMapping("/{dishId}/photos")
    public ResponseEntity<DishPhoto> uploadPhoto(@PathVariable Long dishId, @RequestParam("file") MultipartFile file) {
        Dish dish = dishService.findById(dishId).orElseThrow(() -> new RuntimeException("Dish not found"));
        String filePath = fileStorageService.store(file);
        DishPhoto photo = new DishPhoto(filePath);
        photo.setDish_id(dish.getId());
        dish.getPhotos().add(photo);
        dishPhotoService.save(photo);
        dishService.save(dish);
        return ResponseEntity.ok(photo);
    }
}
