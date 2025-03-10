package com.BaceletShop.controller;

import com.BaceletShop.entities.Product;
import com.BaceletShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping(value = "/product")
    public Optional<Product> getProducts(@RequestParam(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/products")
    public List<Product> getAllProducts() {
        return service.findAll();
    }

    @PostMapping(value = "/product")
    public Product createProducts(@RequestBody Product product) {
        return service.createObservation(product);
    }

}
