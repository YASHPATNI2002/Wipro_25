package com.wipro.food_service.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.wipro.food_service.entity.Food;
import com.wipro.food_service.service.FoodService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService service;

    public FoodController(FoodService service) {
        this.service = service;
    }

    @GetMapping
    public List<Food> all(){ return service.findAll(); }

    @GetMapping("/{id}")
    public Food one(@PathVariable Integer id){ return service.findById(id); }

    @PostMapping
    public Food create(@RequestBody Food f){ return service.create(f); }

    @PutMapping("/{id}")
    public Food update(@PathVariable Integer id, @RequestBody Food f){ return service.update(id, f); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){ service.deleteById(id); }
}
