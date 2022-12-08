package com.example.munchies.service;

import com.example.munchies.model.dto.RestaurantCreationDTO;
import com.example.munchies.model.dto.RestaurantDTO;
import com.example.munchies.model.entity.DeliveryInfoEntity;
import com.example.munchies.model.entity.RestaurantEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomMapping {

    public RestaurantEntity mapRestaurantCreationDtoToEntities(RestaurantCreationDTO restaurantDTO){
        RestaurantEntity restaurant = new RestaurantEntity();
        restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
        restaurant.setRestaurantAddress(restaurantDTO.getRestaurantAddress());
        restaurant.setRestaurantPhoneNumber(restaurantDTO.getRestaurantPhoneNumber());
        restaurant.setRestaurantMenuUrl(restaurantDTO.getRestaurantMenuUrl());
        restaurant.setRestaurantShortName(generateShortName(restaurantDTO.getRestaurantName()));

        DeliveryInfoEntity deliveryInfo = new DeliveryInfoEntity();
        deliveryInfo.setDeliveryInfoTime(restaurantDTO.getDeliveryInfoTime());
        deliveryInfo.setDeliveryInfoAdditionalCharges(restaurantDTO.getDeliveryInfoAdditionalCharges());

        restaurant.setDeliveryInfoEntity(deliveryInfo);
        deliveryInfo.setRestaurantEntity(restaurant);
        return restaurant;
    }

    public RestaurantEntity mapRestaurantUpdateDtoToEntities(RestaurantEntity restaurantEntity, RestaurantCreationDTO restaurantCreationDTO){
        restaurantEntity.setRestaurantName(restaurantCreationDTO.getRestaurantName());
        restaurantEntity.setRestaurantShortName(generateShortName(restaurantCreationDTO.getRestaurantName()));
        restaurantEntity.setRestaurantAddress(restaurantCreationDTO.getRestaurantAddress());
        restaurantEntity.setRestaurantPhoneNumber(restaurantCreationDTO.getRestaurantPhoneNumber());
        restaurantEntity.setRestaurantMenuUrl(restaurantCreationDTO.getRestaurantMenuUrl());
        restaurantEntity.setRestaurantUpdated(LocalDateTime.now());

        DeliveryInfoEntity deliveryInfo = new DeliveryInfoEntity();
        deliveryInfo.setRestaurantEntity(restaurantEntity);
        deliveryInfo = restaurantEntity.getDeliveryInfoEntity();
        deliveryInfo.setDeliveryInfoTime(restaurantCreationDTO.getDeliveryInfoTime());
        deliveryInfo.setDeliveryInfoAdditionalCharges(restaurantCreationDTO.getDeliveryInfoAdditionalCharges());
        deliveryInfo.setDeliveryInfoUpdated(LocalDateTime.now());

        return restaurantEntity;
    }

    public RestaurantDTO mapRestaurantEntityToRestaurantDto(RestaurantEntity restaurantEntity){
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setRestaurantId(restaurantEntity.getRestaurantId());
        restaurantDTO.setRestaurantName(restaurantEntity.getRestaurantName());
        restaurantDTO.setRestaurantShortName(generateShortName(restaurantEntity.getRestaurantName()));
        restaurantDTO.setRestaurantAddress(restaurantEntity.getRestaurantAddress());
        restaurantDTO.setRestaurantPhoneNumber(restaurantEntity.getRestaurantPhoneNumber());
        restaurantDTO.setRestaurantMenuUrl(restaurantEntity.getRestaurantMenuUrl());
        restaurantDTO.setDeliveryInfoTime(restaurantEntity.getDeliveryInfoEntity().getDeliveryInfoTime());
        restaurantDTO.setDeliveryInfoAdditionalCharges(restaurantEntity.getDeliveryInfoEntity().getDeliveryInfoAdditionalCharges());
        return restaurantDTO;
    }

    public String generateShortName(String name){
        return name.replaceAll(" ", "_");
    }
}
