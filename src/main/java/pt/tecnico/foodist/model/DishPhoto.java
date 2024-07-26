package pt.tecnico.foodist.model;

import jakarta.persistence.*;


@Entity
public class DishPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    public DishPhoto() {}

    public DishPhoto(String photoUrl, Dish dish) {
        this.photoUrl = photoUrl;
        this.dish = dish;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}
