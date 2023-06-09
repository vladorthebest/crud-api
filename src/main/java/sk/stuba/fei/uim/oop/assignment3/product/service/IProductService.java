package sk.stuba.fei.uim.oop.assignment3.product.service;

import sk.stuba.fei.uim.oop.assignment3.product.dto.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.model.Product;

import java.util.List;

public interface IProductService {
        List<Product> getList();
        Product create(ProductRequest product);
        Product getRetrieve(Long id);
        Product update(ProductRequest request, Long id);
        void delete(Long id);
        Long getAmount(Long id);
        Long addAmount(ProductRequest request, Long id);
}
