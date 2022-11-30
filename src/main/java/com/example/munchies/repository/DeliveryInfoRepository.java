package com.example.munchies.repository;

import com.example.munchies.model.entity.DeliveryInfoEntity;
import com.example.munchies.model.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfoEntity, Integer> {
    DeliveryInfoEntity findDeliveryInfoEntityByRestaurantEntity(RestaurantEntity restaurant);
}
