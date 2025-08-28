package com.wipro.food_service.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.food_service.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {
 
	
}
