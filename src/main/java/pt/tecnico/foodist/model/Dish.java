package pt.tecnico.foodist.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @OneToMany
    @JoinColumn(name = "dish_id")
    private List<DishPhoto> photos;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Dish() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<DishPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<DishPhoto> photos) {
        this.photos = photos;
    }
}
