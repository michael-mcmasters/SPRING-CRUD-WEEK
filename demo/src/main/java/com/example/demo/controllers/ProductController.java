package com.example.demo.controllers;

import com.example.demo.mocks.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Iterable<Product>> getAllProduct() {
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/products/[id]")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @GetMapping("products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(this.productService.createProduct(product));
    }

    @PutMapping("/products/[id]")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product) {
        product.setId(id);
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus deleteProduct(@PathVariable long id) {
        this.productService.deleteProduct(id);
        return HttpStatus.OK;
    }
}
