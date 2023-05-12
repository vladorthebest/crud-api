package sk.stuba.fei.uim.oop.assignment3.cart.dto;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.model.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.model.ProductCart;
import java.util.List;


@Getter
@Setter
public class CartResponse {
    private Long id;
    private List<ProductCart> shoppingList;
    private boolean payed;

    public CartResponse(Cart c){
        this.id = c.getId();
        this.shoppingList = c.getShoppingList();
        this.payed = c.isPayed();
    }

}
