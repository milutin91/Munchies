package com.example.munchies.repository;

import com.example.munchies.model.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Integer> {
    boolean existsByRestaurantName(String restaurantName);
}
