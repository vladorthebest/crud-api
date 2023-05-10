package sk.stuba.fei.uim.oop.assignment3.cart.model;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.dto.ProductCardRequest;
import sk.stuba.fei.uim.oop.assignment3.product.model.Product;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class ProductCart {

    @Id
    private Long productId;
    private Long amount;

    public ProductCart(ProductCardRequest product) {
        this.productId = product.getProductId();
        this.amount = product.getAmount();
    }

    public ProductCart(){}
}
