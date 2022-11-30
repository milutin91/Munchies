package com.example.munchies.repository;

import com.example.munchies.model.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Integer> {
    boolean existsByRestaurantName(String restaurantName);

//    @Query("SELECT new com/example/munchies/model/dto/NewRestaurantDTO(r.restaurantName, r.restaurantAddress, r.restaurantPhoneNumber, r.restaurantMenuUrl, r.deliveryInfoTime, r.deliveryInfoAdditionalCharges) FROM RestaurantEntity r\n" +
//            " join DeliveryInfoEntity d")
//    List<?> getRestaurants();
}
