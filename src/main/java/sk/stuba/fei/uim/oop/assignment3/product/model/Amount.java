package sk.stuba.fei.uim.oop.assignment3.product.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class Amount {
    private Long amount;

    public Amount(Long amount) {
        this.amount = amount;
    }
}
