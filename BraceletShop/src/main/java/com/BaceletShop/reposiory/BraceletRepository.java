package com.BaceletShop.reposiory;

import com.BaceletShop.entities.Bracelet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BraceletRepository extends JpaRepository<Bracelet, Long> {

    Bracelet getById(Long id);

}
