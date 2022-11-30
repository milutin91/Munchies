package com.example.munchies.service;

import com.example.munchies.model.dto.NewRestaurantDTO;
import com.example.munchies.model.entity.DeliveryInfoEntity;
import com.example.munchies.model.entity.RestaurantEntity;
import com.example.munchies.repository.DeliveryInfoRepository;
import com.example.munchies.repository.RestaurantRepository;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private DeliveryInfoRepository deliveryInfoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public String addRestaurant(NewRestaurantDTO restaurantDTO) {
//        if(!restaurantRepository.existsByRestaurantName(mapToDTO(restaurant).getRestaurantName())){
//            restaurant.setRestaurantCreated(LocalDateTime.now());
//            restaurantRepository.save(restaurant);
//            return "Restaurant created";
//        }else{
//            return "Restaurant already exist!";
//        }
        RestaurantEntity restaurant = new RestaurantEntity();
        DeliveryInfoEntity deliveryInfo = new DeliveryInfoEntity();
        restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
        restaurant.setRestaurantAddress(restaurantDTO.getRestaurantAddress());
        restaurant.setRestaurantPhoneNumber(restaurantDTO.getRestaurantPhoneNumber());
        restaurant.setRestaurantMenuUrl(restaurantDTO.getRestaurantMenuUrl());
        restaurant.setRestaurantCreated(LocalDateTime.now());
        restaurantRepository.save(restaurant);
        deliveryInfo.setDeliveryInfoTime(restaurantDTO.getDeliveryInfoTime());
        deliveryInfo.setDeliveryInfoAdditionalCharges(restaurantDTO.getDeliveryInfoAdditionalCharges());
        deliveryInfoRepository.save(deliveryInfo);
        return "new restaurant created";
    }

    public List<RestaurantEntity> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    private NewRestaurantDTO mapToDTO(RestaurantEntity restaurant){
        NewRestaurantDTO newRestaurantDTO = modelMapper.map(restaurant, NewRestaurantDTO.class);
        return newRestaurantDTO;
    }

    private RestaurantEntity mapToEntity(NewRestaurantDTO restaurantDTO){
        RestaurantEntity restaurant = modelMapper.map(restaurantDTO, RestaurantEntity.class);
        return restaurant;
    }
}
