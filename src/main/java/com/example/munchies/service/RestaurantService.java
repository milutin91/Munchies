package com.example.munchies.service;

import com.example.munchies.model.dto.RestaurantCreationDTO;
import com.example.munchies.model.dto.RestaurantDTO;
import com.example.munchies.model.entity.RestaurantEntity;
import com.example.munchies.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private CustomMapping customMapping;

    public RestaurantDTO createRestaurant(RestaurantCreationDTO restaurantDTO) {
        RestaurantEntity restaurantEntity = customMapping.mapRestaurantCreationDtoToEntities(restaurantDTO);
        restaurantRepository.save(restaurantEntity);
        return customMapping.mapRestaurantEntityToRestaurantDto(restaurantEntity);
    }

    public List<RestaurantDTO> getAllRestaurants() {
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();
        List<RestaurantDTO> restaurantDTOS = new ArrayList<>();
        for (var restaurant : restaurants) {
            restaurantDTOS.add(customMapping.mapRestaurantEntityToRestaurantDto(restaurant));
        }
        return restaurantDTOS;
    }

    public RestaurantDTO findRestaurantDetails(Integer id) {
        RestaurantEntity restaurant = restaurantRepository.findById(id).get();

        return customMapping.mapRestaurantEntityToRestaurantDto(restaurant);
    }

    public void deleteRestaurant(Integer id) {
        restaurantRepository.deleteById(id);
    }

    public RestaurantDTO updateRestaurant(Integer id, RestaurantCreationDTO restaurantDTO) {
        RestaurantEntity restaurantToUpdate = restaurantRepository.findById(id).get();
        restaurantToUpdate = customMapping.mapRestaurantUpdateDtoToEntities(restaurantToUpdate, restaurantDTO);
        restaurantRepository.save(restaurantToUpdate);
        return customMapping.mapRestaurantEntityToRestaurantDto(restaurantToUpdate);
    }
}
