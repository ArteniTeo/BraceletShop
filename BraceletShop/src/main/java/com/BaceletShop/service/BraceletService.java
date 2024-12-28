package com.BaceletShop.service;

import com.BaceletShop.entities.Bracelet;
import com.BaceletShop.reposiory.BraceletRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BraceletService {

    private final BraceletRepository repository;

    public Bracelet createObservation(Bracelet bracelet) {
        return repository.save(bracelet);
    }

    public Optional<Bracelet> findById(Long id) {
        return repository.findById(id);
    }

    public List<Bracelet> findAll() {
        return repository.findAll();
    }
}
