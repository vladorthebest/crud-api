package sk.stuba.fei.uim.oop.assignment3.cart.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(cascade = {CascadeType.ALL})
    private List<ProductCart> shoppingList;

    private boolean payed;

    public Cart(){
        shoppingList = new ArrayList<>();
        payed = false;
    }
}
