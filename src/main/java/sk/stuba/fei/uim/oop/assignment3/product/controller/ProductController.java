package sk.stuba.fei.uim.oop.assignment3.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import sk.stuba.fei.uim.oop.assignment3.product.dto.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.dto.ProductResponse;
import sk.stuba.fei.uim.oop.assignment3.product.model.Product;
import sk.stuba.fei.uim.oop.assignment3.product.service.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private IProductService service;

    @Autowired
    public ProductController(IProductService service){

        this.service = service;
    }

    @GetMapping()
    public List<ProductResponse> getListProducts(){
        ArrayList list = new ArrayList<ProductResponse>();

        for(Product p : this.service.getList()){
            list.add(new ProductResponse(p));
        }

        return list;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProducts(@RequestBody ProductRequest request){
        Product product = this.service.create(request);
        return new ProductResponse(product);
    }

    @GetMapping("/{id}")
    public ProductResponse getRetrieve(@PathVariable("id") int id) {
        Product product = this.service.getRetrieve(id);
        return new ProductResponse(product);
    }

    @PutMapping("/{id}")
    public ProductResponse update(@RequestBody ProductRequest request, @PathVariable("id") int id) {
        Product product = this.service.update(request, id);
        return new ProductResponse(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        this.service.delete(id);
    }

}
