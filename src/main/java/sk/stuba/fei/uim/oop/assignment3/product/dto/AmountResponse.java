package sk.stuba.fei.uim.oop.assignment3.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmountResponse {
    private Long amount;
    public AmountResponse(Long amount) {
        this.amount = amount;
    }
}
