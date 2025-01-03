package com.BaceletShop.controller;

import com.BaceletShop.entities.Bracelet;
import com.BaceletShop.service.BraceletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequiredArgsConstructor
public class BraceletController {

    private final BraceletService service;

    @GetMapping(value = "/bracelet")
    public Optional<Bracelet> getObservation(@RequestParam(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/bracelets")
    public List<Bracelet> getAllObservations() {
        return service.findAll();
    }

    @PostMapping(value = "/bracelet")
    public Bracelet createObservation(@RequestBody Bracelet bracelet) {
        return service.createObservation(bracelet);
    }

}
