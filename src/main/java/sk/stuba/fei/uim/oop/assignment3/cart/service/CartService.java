package sk.stuba.fei.uim.oop.assignment3.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sk.stuba.fei.uim.oop.assignment3.cart.model.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.model.ProductCart;
import sk.stuba.fei.uim.oop.assignment3.cart.repository.CartRepository;
import sk.stuba.fei.uim.oop.assignment3.product.model.Product;
import sk.stuba.fei.uim.oop.assignment3.product.repository.ProductRepository;


@Service
public class CartService implements ICartService{

    @Autowired
    private CartRepository repository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Cart create() {
        return this.repository.save(new Cart());
    }

    @Override
    public Cart getRetrieve(Long id) {
        return this.repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        Cart cart = this.repository.findById(id).orElseThrow();

        this.repository.delete(cart);
    }

    @Override
    public Cart addProduct(ProductCart productAdd, Long id) {
        Cart cart = this.repository.findById(id).orElseThrow();

        if(cart.isPayed()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Product productStock = productRepository.findById(productAdd.getProductId()).orElseThrow();

        if(productStock.getAmount() < productAdd.getAmount()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        boolean added = false;
        for(ProductCart productInCart: cart.getShoppingList()){
            if(productInCart.getProductId().equals(productAdd.getProductId())){
                productInCart.setAmount(productInCart.getAmount() + productAdd.getAmount());
                added = true;
                break;
            }
        }
        if (!added) {
            cart.getShoppingList().add(productAdd);
        }

        productStock.setAmount(productStock.getAmount() - productAdd.getAmount());
        this.productRepository.save(productStock);
        this.repository.save(cart);
        return cart;
    }

    @Override
    public Double payCart(Long id) {
        Cart cart = this.repository.findById(id).orElseThrow();

        if(cart.isPayed()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        double sum = 0;
        cart.setPayed(true);
        this.repository.save(cart);
        for(ProductCart productInCart: cart.getShoppingList()){
            Product product = this.productRepository.findById(productInCart.getProductId()).orElseThrow();
            sum += product.getPrice() * productInCart.getAmount();
        }

        return sum;
    }
}
