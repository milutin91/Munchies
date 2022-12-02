package com.example.munchies.service;

import com.example.munchies.model.dto.DeliveryInfoDTO;
import com.example.munchies.model.dto.NewOrUpdateRestaurantDTO;
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

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private DeliveryInfoRepository deliveryInfoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public String addRestaurant(NewOrUpdateRestaurantDTO restaurantDTO, DeliveryInfoDTO deliveryInfoDTO) {
        RestaurantEntity restaurant = new RestaurantEntity();
        DeliveryInfoEntity deliveryInfo = new DeliveryInfoEntity();
        restaurant = mapNewRestaurantDTOToRestaurantEntity(restaurantDTO, deliveryInfoDTO);
        deliveryInfo = restaurant.getDeliveryInfoEntity();
        deliveryInfo.setRestaurantEntity(restaurant);
        restaurant.setRestaurantCreated(LocalDateTime.now());
        String shortName = restaurantDTO.getRestaurantName().replaceAll(" ", "_");
        restaurant.setRestaurantShortName(shortName);
        restaurantRepository.save(restaurant);
        return "new restaurant created";
    }

    public List<RestaurantViewDTO> getAllRestaurants() {
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();
        List<RestaurantViewDTO> restaurantViewDTOS = new ArrayList<>();
        for (var restaurant : restaurants) {
            restaurantViewDTOS.add(mapRestaurantViewToDTO(restaurant));
        }
        return restaurantViewDTOS;
    }

    public RestaurantDetailsDTO findRestaurantDetails(Integer id) {
        RestaurantEntity restaurant = restaurantRepository.findById(id).get();
        DeliveryInfoEntity deliveryInfo = deliveryInfoRepository.findDeliveryInfoByRestaurantEntity(restaurant);
        RestaurantDetailsDTO restaurantDetailsDto1 = mapRestaurantDetailsToDTO(restaurant, deliveryInfo);
        restaurantDetailsDto1 = mapRestaurantDetailsToDTO(restaurant, deliveryInfo);
        return restaurantDetailsDto1;
    }

    private RestaurantViewDTO mapRestaurantViewToDTO(RestaurantEntity restaurant) {
        RestaurantViewDTO restaurantViewDTO = modelMapper.map(restaurant, RestaurantViewDTO.class);
        return restaurantViewDTO;
    }

    private RestaurantDetailsDTO mapRestaurantDetailsToDTO(RestaurantEntity restaurant, DeliveryInfoEntity deliveryInfo) {
        RestaurantDetailsDTO restaurantDetailsDto = modelMapper.map(restaurant, RestaurantDetailsDTO.class);
        DeliveryInfoDTO deliveryInfoDTO = modelMapper.map(deliveryInfo, DeliveryInfoDTO.class);
        restaurantDetailsDto.setDeliveryInfoDTO(deliveryInfoDTO);
        return restaurantDetailsDto;
    }

    private RestaurantEntity mapNewRestaurantDTOToRestaurantEntity(NewOrUpdateRestaurantDTO newOrUpdateRestaurantDTO, DeliveryInfoDTO deliveryInfoDTO) {
        RestaurantEntity restaurant = modelMapper.map(newOrUpdateRestaurantDTO, RestaurantEntity.class);
        DeliveryInfoEntity deliveryInfo = modelMapper.map(deliveryInfoDTO, DeliveryInfoEntity.class);
        restaurant.setDeliveryInfoEntity(deliveryInfo);
        return restaurant;
    }

    public void deleteRestaurant(Integer id) {
        restaurantRepository.deleteById(id);
    }

    public void updateRestaurant(Integer id, NewOrUpdateRestaurantDTO restaurantDTO, DeliveryInfoDTO deliveryInfoDTO) {
        RestaurantEntity restaurantToUpdate = restaurantRepository.findById(id).get();
        restaurantToUpdate.setRestaurantName(restaurantDTO.getRestaurantName());
        String shortName = restaurantDTO.getRestaurantName().replaceAll(" ", "_");
        restaurantToUpdate.setRestaurantShortName(shortName);
        restaurantToUpdate.setRestaurantAddress(restaurantDTO.getRestaurantAddress());
        restaurantToUpdate.setRestaurantPhoneNumber(restaurantDTO.getRestaurantPhoneNumber());
        restaurantToUpdate.setRestaurantMenuUrl(restaurantDTO.getRestaurantMenuUrl());
        restaurantToUpdate.setRestaurantUpdated(LocalDateTime.now());

        DeliveryInfoEntity deliveryInfo = new DeliveryInfoEntity();
        deliveryInfo = restaurantToUpdate.getDeliveryInfoEntity();
        deliveryInfo.setDeliveryInfoTime(deliveryInfoDTO.getDeliveryInfoTime());
        deliveryInfo.setDeliveryInfoAdditionalCharges(deliveryInfoDTO.getDeliveryInfoAdditionalCharges());
        deliveryInfo.setDeliveryInfoUpdated(LocalDateTime.now());

        deliveryInfo.setRestaurantEntity(restaurantToUpdate);

        restaurantRepository.save(restaurantToUpdate);

    }
}
