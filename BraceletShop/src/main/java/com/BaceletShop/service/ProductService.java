package com.BaceletShop.service;

import com.BaceletShop.entities.Product;
import com.BaceletShop.reposiory.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product createObservation(Product product) {
        return repository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    public Product findProductById(Long id) {
        return repository.findProductById(id);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }
}
