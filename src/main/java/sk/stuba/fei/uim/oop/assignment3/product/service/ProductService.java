package sk.stuba.fei.uim.oop.assignment3.product.service;


import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.product.dto.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.model.Product;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Override
    public List<Product> getList() {
        return null;
    }

    @Override
    public Product create(ProductRequest product) {
        return null;
    }

    @Override
    public Product getRetrieve(int id) {
        return null;
    }

    @Override
    public Product update(ProductRequest request, int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
