package com.example.munchies.service;

import com.example.munchies.ExceptionHandling.NotFoundException;
import com.example.munchies.mapper.RestaurantMapper;
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
    private RestaurantMapper restaurantMapper;

    public RestaurantDTO createRestaurant(RestaurantCreationDTO restaurantDTO) {
        RestaurantEntity restaurantEntity = restaurantMapper.mapRestaurantCreationDtoToEntities(restaurantDTO);
        RestaurantEntity restaurantResponse = restaurantRepository.save(restaurantEntity);
        return restaurantMapper.mapRestaurantEntityToRestaurantDto(restaurantResponse);
    }

    public List<RestaurantDTO> getAllRestaurants() {
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();
        List<RestaurantDTO> restaurantDTOS = new ArrayList<>();
        for (var restaurant : restaurants) {
            restaurantDTOS.add(restaurantMapper.mapRestaurantEntityToRestaurantDto(restaurant));
        }
        return restaurantDTOS;
    }

    public RestaurantDTO findRestaurantDetails(Integer id) throws NotFoundException {
        RestaurantEntity restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Restaurant doesn't exist"));

        return restaurantMapper.mapRestaurantEntityToRestaurantDto(restaurant);
    }

    public void deleteRestaurant(Integer id) {
        restaurantRepository.deleteById(id);
    }

    public RestaurantDTO updateRestaurant(Integer id, RestaurantCreationDTO restaurantDTO) {
        RestaurantEntity restaurantToUpdate = restaurantRepository.findById(id).get();
        restaurantToUpdate = restaurantMapper.mapRestaurantUpdateDtoToEntities(restaurantToUpdate, restaurantDTO);
        RestaurantEntity restaurantResponse = restaurantRepository.save(restaurantToUpdate);
        return restaurantMapper.mapRestaurantEntityToRestaurantDto(restaurantResponse);
    }
}
