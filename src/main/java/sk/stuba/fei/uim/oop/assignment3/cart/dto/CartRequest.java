package sk.stuba.fei.uim.oop.assignment3.cart.dto;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.model.ProductCart;

import java.util.List;

@Getter
@Setter
public class CartRequest {
    private Long id;
    private List<ProductCart> shoppingList;
    private boolean payed;
}
