package com.example.munchies.service;

import com.example.munchies.model.dto.NewRestaurantDTO;
import com.example.munchies.model.dto.RestaurantDetailsDTO;
import com.example.munchies.model.dto.RestaurantViewDTO;
import com.example.munchies.model.entity.DeliveryInfoEntity;
import com.example.munchies.model.entity.RestaurantEntity;
import com.example.munchies.repository.DeliveryInfoRepository;
import com.example.munchies.repository.RestaurantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private DeliveryInfoRepository deliveryInfoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public String addRestaurant(NewRestaurantDTO restaurantDTO) {
        RestaurantEntity restaurant = new RestaurantEntity();
        DeliveryInfoEntity deliveryInfo = new DeliveryInfoEntity();
        restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
        restaurant.setRestaurantAddress(restaurantDTO.getRestaurantAddress());
        restaurant.setRestaurantPhoneNumber(restaurantDTO.getRestaurantPhoneNumber());
        restaurant.setRestaurantMenuUrl(restaurantDTO.getRestaurantMenuUrl());
        restaurant.setRestaurantCreated(LocalDateTime.now());
        String shortName = restaurantDTO.getRestaurantName().replaceAll(" ", "_");
        restaurant.setRestaurantShortName(shortName);
        restaurantRepository.save(restaurant);
        deliveryInfo.setDeliveryInfoTime(restaurantDTO.getDeliveryInfoTime());
        deliveryInfo.setDeliveryInfoAdditionalCharges(restaurantDTO.getDeliveryInfoAdditionalCharges());
        deliveryInfo.setRestaurantEntity(restaurant);
        deliveryInfo.setDeliveryInfoCreated(LocalDateTime.now());
        deliveryInfoRepository.save(deliveryInfo);
        return "new restaurant created";
    }

    public List<RestaurantViewDTO> getAllRestaurants(){
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();
        List<RestaurantViewDTO> restaurantViewDTOS = new ArrayList<>();
        for (var restaurant : restaurants){
            restaurantViewDTOS.add(mapToDTO(restaurant));
        }
        return restaurantViewDTOS;
    }

    public RestaurantDetailsDTO findRestaurantDetails(Integer id){
        RestaurantDetailsDTO restaurantDetailsDTO = new RestaurantDetailsDTO();
        RestaurantEntity restaurant = restaurantRepository.findById(id).get();
        DeliveryInfoEntity deliveryInfo = deliveryInfoRepository.findDeliveryInfoEntityByRestaurantEntity(restaurant);
        restaurantDetailsDTO.setRestaurantName(restaurant.getRestaurantName());
        restaurantDetailsDTO.setRestaurantShortName(restaurant.getRestaurantShortName());
        restaurantDetailsDTO.setRestaurantAddress(restaurant.getRestaurantAddress());
        restaurantDetailsDTO.setRestaurantPhoneNumber(restaurant.getRestaurantPhoneNumber());
        restaurantDetailsDTO.setRestaurantMenuUrl(restaurant.getRestaurantMenuUrl());
        restaurantDetailsDTO.setDeliveryInfoTime(deliveryInfo.getDeliveryInfoTime());
        restaurantDetailsDTO.setDeliveryInfoAdditionalCharges(deliveryInfo.getDeliveryInfoAdditionalCharges());
        return restaurantDetailsDTO;
    }

    private RestaurantViewDTO mapToDTO(RestaurantEntity restaurant){
        RestaurantViewDTO restaurantViewDTO = modelMapper.map(restaurant, RestaurantViewDTO.class);
        return restaurantViewDTO;
    }

    private RestaurantEntity mapToEntity(RestaurantViewDTO restaurantViewDTO){
        RestaurantEntity restaurant = modelMapper.map(restaurantViewDTO, RestaurantEntity.class);
        return restaurant;
    }
}
