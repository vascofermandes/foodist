package pt.tecnico.foodist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.tecnico.foodist.model.Dish;
import pt.tecnico.foodist.service.imp.DishServiceImp;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishServiceImp dishService;

    @GetMapping()
    public List<Dish> findAll(){
        return dishService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Dish> findById(@PathVariable(value = "id") Long id){
        return dishService.findById(id);
    }

    @PostMapping
    public Dish create(@RequestBody Dish dish){
        return dishService.save(dish);
    }

}
