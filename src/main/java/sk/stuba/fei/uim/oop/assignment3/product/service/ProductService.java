package sk.stuba.fei.uim.oop.assignment3.product.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.product.dto.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.model.Product;
import sk.stuba.fei.uim.oop.assignment3.product.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getList() {
        return this.repository.findAll();
    }

    @Override
    public Product getRetrieve(Long id) {
        Product product = this.repository.findById(id).orElseThrow();
        return product;
    }

    @Override
    public Product create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setUnit(request.getUnit());
        product.setDescription(request.getDescription());
        product.setAmount(request.getAmount());

        return this.repository.save(product);
    }


    @Override
    public Product update(ProductRequest request, Long id) {
        Product product = this.repository.findById(id).orElseThrow();

        if(request.getName() != null) {
            product.setName(request.getName());
        }

        if(request.getDescription() != null) {
            product.setDescription(request.getDescription());
        }

        return this.repository.save(product);
    }

    @Override
    public void delete(Long id) {
        Product product = this.repository.findById(id).orElseThrow();

        this.repository.delete(product);
    }

    @Override
    public Long getAmount(Long id) {
        Product product = this.repository.findById(id).orElseThrow();
        return product.getAmount();
    }

    @Override
    public Long addAmount(ProductRequest request, Long id) {
        Product product = this.repository.findById(id).orElseThrow();
        Long newAmount = product.getAmount() + request.getAmount();
        product.setAmount(newAmount);
        this.repository.save(product);
        return product.getAmount();
    }
}
