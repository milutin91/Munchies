package com.example.munchies.service;

import com.example.munchies.model.dto.DeliveryInfoRequestDTO;
import com.example.munchies.model.dto.RestaurantRequestDTO;
import com.example.munchies.model.dto.RestaurantResponseDTO;
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

    public String addRestaurant(RestaurantRequestDTO restaurantDTO, DeliveryInfoRequestDTO deliveryInfoRequestDTO) {
        RestaurantEntity restaurant = new RestaurantEntity();
        DeliveryInfoEntity deliveryInfo = new DeliveryInfoEntity();
        restaurant = mapNewRestaurantDTOToRestaurantEntity(restaurantDTO, deliveryInfoRequestDTO);
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

    public RestaurantResponseDTO findRestaurantDetails(Integer id) {
        RestaurantEntity restaurant = restaurantRepository.findById(id).get();
        DeliveryInfoEntity deliveryInfo = deliveryInfoRepository.findDeliveryInfoByRestaurantEntity(restaurant);
        RestaurantResponseDTO restaurantResponseDto1 = mapRestaurantDetailsToDTO(restaurant, deliveryInfo);
        restaurantResponseDto1 = mapRestaurantDetailsToDTO(restaurant, deliveryInfo);
        return restaurantResponseDto1;
    }

    private RestaurantViewDTO mapRestaurantViewToDTO(RestaurantEntity restaurant) {
        RestaurantViewDTO restaurantViewDTO = modelMapper.map(restaurant, RestaurantViewDTO.class);
        return restaurantViewDTO;
    }

    private RestaurantResponseDTO mapRestaurantDetailsToDTO(RestaurantEntity restaurant, DeliveryInfoEntity deliveryInfo) {
        RestaurantResponseDTO restaurantResponseDto = modelMapper.map(restaurant, RestaurantResponseDTO.class);
        DeliveryInfoRequestDTO deliveryInfoRequestDTO = modelMapper.map(deliveryInfo, DeliveryInfoRequestDTO.class);
        restaurantResponseDto.setDeliveryInfoRequestDTO(deliveryInfoRequestDTO);
        return restaurantResponseDto;
    }

    private RestaurantEntity mapNewRestaurantDTOToRestaurantEntity(RestaurantRequestDTO restaurantRequestDTO, DeliveryInfoRequestDTO deliveryInfoRequestDTO) {
        RestaurantEntity restaurant = modelMapper.map(restaurantRequestDTO, RestaurantEntity.class);
        DeliveryInfoEntity deliveryInfo = modelMapper.map(deliveryInfoRequestDTO, DeliveryInfoEntity.class);
        restaurant.setDeliveryInfoEntity(deliveryInfo);
        return restaurant;
    }

    public void deleteRestaurant(Integer id) {
        restaurantRepository.deleteById(id);
    }

    public void updateRestaurant(Integer id, RestaurantRequestDTO restaurantDTO, DeliveryInfoRequestDTO deliveryInfoRequestDTO) {
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
        deliveryInfo.setDeliveryInfoTime(deliveryInfoRequestDTO.getDeliveryInfoTime());
        deliveryInfo.setDeliveryInfoAdditionalCharges(deliveryInfoRequestDTO.getDeliveryInfoAdditionalCharges());
        deliveryInfo.setDeliveryInfoUpdated(LocalDateTime.now());

        deliveryInfo.setRestaurantEntity(restaurantToUpdate);

        restaurantRepository.save(restaurantToUpdate);

    }
}
