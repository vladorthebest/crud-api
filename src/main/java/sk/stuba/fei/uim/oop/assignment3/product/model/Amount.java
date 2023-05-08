package sk.stuba.fei.uim.oop.assignment3.product.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Amount {
    Long amount;

    public Amount(Long amount) {
        this.amount = amount;
    }
}
