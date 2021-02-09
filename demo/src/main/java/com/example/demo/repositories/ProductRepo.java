package com.example.demo.repositories;

import com.example.demo.mocks.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long> {

}
