package com.example.munchies.repository;

import com.example.munchies.model.entity.DeliveryInfoEntity;
import com.example.munchies.model.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfoEntity, Integer> {
    DeliveryInfoEntity findDeliveryInfoByRestaurantEntity(RestaurantEntity restaurant);
}
