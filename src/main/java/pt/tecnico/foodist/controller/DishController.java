package pt.tecnico.foodist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.tecnico.foodist.model.Dish;
import pt.tecnico.foodist.model.DishPhoto;
import pt.tecnico.foodist.model.FoodService;
import pt.tecnico.foodist.service.imp.DishServiceImp;
import pt.tecnico.foodist.service.imp.FoodServiceServiceImp;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishServiceImp dishService;

    @Autowired
    private FoodServiceServiceImp foodServiceService;

    @GetMapping()
    public List<Dish> findAll(){
        return dishService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Dish> findById(@PathVariable(value = "id") Long id){
        return dishService.findById(id);
    }
    @GetMapping("/photos/{id}")
    public List<DishPhoto> findPhotosByDish(@PathVariable(value = "id") Long id){
        return dishService.findById(id).get().getPhotos();
    }
    @PostMapping("/{foodServiceID}/foodService")
    public Dish create(@PathVariable Long foodServiceID, @RequestBody Dish dish){
        Optional<FoodService> foodService = foodServiceService.findById(foodServiceID);
        if(foodService.isPresent()){
            Dish dishWithId = dishService.save(dish);
            foodService.get().getDishes().add(dishWithId);
            foodServiceService.create(foodService.get());
            return dishWithId;
        }
        return null;
    }

}
