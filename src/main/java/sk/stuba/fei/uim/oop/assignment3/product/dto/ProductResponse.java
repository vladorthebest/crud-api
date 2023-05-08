package sk.stuba.fei.uim.oop.assignment3.product.dto;

import sk.stuba.fei.uim.oop.assignment3.product.model.Product;

public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private Long amount;
    private String unit;
    private double price;

    public ProductResponse(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.amount = product.getAmount();
        this.unit = product.getUnit();
        this.price = product.getPrice();
    }

}
