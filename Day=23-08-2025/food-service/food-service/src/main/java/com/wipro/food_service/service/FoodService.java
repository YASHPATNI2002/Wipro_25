package com.wipro.food_service.service;

import com.wipro.food_service.entity.Food;

import java.util.List;

public interface FoodService {
    List<Food> findAll();
    Food findById(Integer id);
    Food create(Food food);
    Food update(Integer id, Food food);
    void deleteById(Integer id);
}
