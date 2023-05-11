package sk.stuba.fei.uim.oop.assignment3.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.dto.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.cart.model.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.model.ProductCart;
import sk.stuba.fei.uim.oop.assignment3.cart.service.ICartService;
import sk.stuba.fei.uim.oop.assignment3.product.dto.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.dto.ProductResponse;
import sk.stuba.fei.uim.oop.assignment3.product.model.Product;
import sk.stuba.fei.uim.oop.assignment3.product.service.IProductService;

@RequestMapping("/cart")
@RestController
public class CartController {
    private ICartService service;

    @Autowired
    public CartController(ICartService service){
        this.service = service;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CartResponse createCart(){
        Cart cart = this.service.create();
        return new CartResponse(cart);
    }

    @GetMapping("/{id}")
    public CartResponse getRetrieve(@PathVariable("id") Long id) {
        Cart cart = this.service.getRetrieve(id);
        return new CartResponse(cart);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.service.delete(id);
    }

    @PostMapping("/{id}/add")
    public CartResponse addProduct(@RequestBody ProductCart request, @PathVariable("id") Long id){
        Cart cart = this.service.addProduct(request,id);
        return new CartResponse(cart);
    }

    @GetMapping("/{id}/pay")
    public String payCart(@PathVariable("id") Long id) {
        return this.service.payCart(id);
    }
}
