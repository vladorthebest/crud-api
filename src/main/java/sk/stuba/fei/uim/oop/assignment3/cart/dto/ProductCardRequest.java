package sk.stuba.fei.uim.oop.assignment3.cart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCardRequest {
    private Long productId;
    private Long amount;
}
