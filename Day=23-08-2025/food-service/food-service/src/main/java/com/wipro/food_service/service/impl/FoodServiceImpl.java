package com.wipro.food_service.service.impl;

import com.wipro.food_service.entity.Food;
import com.wipro.food_service.repository.FoodRepository;
import com.wipro.food_service.service.FoodService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

    private final FoodRepository repo;   

    public FoodServiceImpl(FoodRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Food> findAll() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Food findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Food not found: " + id));
    }

    @Override
    public Food create(Food food) {
        food.setId(null); // ensure insert
        return repo.save(food);
    }

    @Override
    public Food update(Integer id, Food food) {
        Food existing = findById(id); // throws if not found
        existing.setName(food.getName());
        existing.setCategory(food.getCategory());
        existing.setPrice(food.getPrice());
        existing.setAvailable(food.getAvailable());
        existing.setImageUrl(food.getImageUrl());
        return repo.save(existing);
    }

    @Override
    public void deleteById(Integer id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Food not found: " + id);
        }
        repo.deleteById(id);
    }
}
