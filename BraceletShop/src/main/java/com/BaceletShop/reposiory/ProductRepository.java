package com.BaceletShop.reposiory;

import com.BaceletShop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getById(Long id);

}
