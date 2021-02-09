package com.example.demo.services;

import com.example.demo.mocks.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product updateProduct(Product product);

    Iterable<Product> getAllProduct();

    Product getProductById(long productId);

    void deleteProduct(long id);
}
