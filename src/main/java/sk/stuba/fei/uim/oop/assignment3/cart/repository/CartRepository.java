package sk.stuba.fei.uim.oop.assignment3.cart.repository;

import org.springframework.data.repository.CrudRepository;
import sk.stuba.fei.uim.oop.assignment3.cart.model.Cart;


public interface CartRepository extends CrudRepository<Cart, Long> {
}
