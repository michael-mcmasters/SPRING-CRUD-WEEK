package com.example.demo.services;

import com.example.demo.mocks.Product;
import com.example.demo.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

// Service is how we are going to add product to the repo.
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;


    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> productDb = this.productRepo.findById(product.getId());

        if (productDb.isPresent()) {
            Product productUpdate = productDb.get();
            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            productRepo.save(productUpdate);
        } else {
            //throw new ResourceNotFoundException("Record not found with id : " + product.getId());
        }
        return null;
    }

    @Override
    public Iterable<Product> getAllProduct() {
        return this.productRepo.findAll();
    }

    @Override
    public Product getProductById(long productId) {
        Optional<Product> productDb = this.productRepo.findById(productId);

        if (productDb.isPresent()) {
            return productDb.get();
        } else {
            //throw new ResourceNotFoundException("Record not found with id : " + productId);
            return null;
        }
    }

    @Override
    public void deleteProduct(long id) {
        Optional<Product> productDb = this.productRepo.findById(id);

        if (productDb.isPresent()) {
            this.productRepo.delete(productDb.get());
        } else {
            //throw new ResourceNotFoundException("Record not found with id : " + productId);
        }
    }
}
