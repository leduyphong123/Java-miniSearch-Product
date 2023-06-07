package service;

import entity.Product;

import java.util.List;

public interface ProductService {
    boolean newProduct(Product Product);
    List<Product> getProductAll();
}
