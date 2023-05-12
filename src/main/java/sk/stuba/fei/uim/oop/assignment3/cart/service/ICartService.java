package sk.stuba.fei.uim.oop.assignment3.cart.service;

import sk.stuba.fei.uim.oop.assignment3.cart.model.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.model.ProductCart;

public interface ICartService {
    Cart create();
    Cart getRetrieve(Long id);
    void delete(Long id);
    Cart addProduct(ProductCart product, Long id);
    Double payCart(Long id);
}
