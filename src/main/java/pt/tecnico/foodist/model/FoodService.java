package pt.tecnico.foodist.model;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
public class FoodService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalTime openHour;

    private LocalTime closeHour;

    @OneToMany
    @JoinColumn(name = "food_service_id")
    private List<Dish> dishes;

    public FoodService() {
    }

    public FoodService(String name, LocalTime openHour, LocalTime closeHour, List<Dish> dishes) {
        this.name = name;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.dishes = dishes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getOpenHour() {
        return openHour;
    }

    public void setOpenHour(LocalTime openHour) {
        this.openHour = openHour;
    }

    public LocalTime getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(LocalTime closeHour) {
        this.closeHour = closeHour;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
