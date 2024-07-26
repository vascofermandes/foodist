package pt.tecnico.foodist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.tecnico.foodist.model.Dish;
import pt.tecnico.foodist.model.FoodService;
import pt.tecnico.foodist.service.imp.FoodServiceServiceImp;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foodservices")
public class FoodServiceController {


        @Autowired
        private FoodServiceServiceImp foodServiceService;

        @GetMapping
        public ResponseEntity<List<FoodService>> findAll(){
            return ResponseEntity.ok(foodServiceService.findAll());

        }

    @GetMapping("/{id}/dishes")
    public ResponseEntity<List<Dish>> getDishesByFoodServiceId(@PathVariable Long id){
        Optional<FoodService> foodService = foodServiceService.findById(id);
        if(foodService.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(foodService.get().getDishes());
    }
}
