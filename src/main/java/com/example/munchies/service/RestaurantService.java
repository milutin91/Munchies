package com.example.munchies.service;

import com.example.munchies.ExceptionHandling.NotFoundException;
import com.example.munchies.ExceptionHandling.RestaurantWithActiveOrderException;
import com.example.munchies.mapper.GroupOrderMapper;
import com.example.munchies.mapper.RestaurantMapper;
import com.example.munchies.model.dto.GroupOrderDTO;
import com.example.munchies.model.dto.RestaurantCreationDTO;
import com.example.munchies.model.dto.RestaurantDTO;
import com.example.munchies.model.entity.GroupOrderEntity;
import com.example.munchies.model.entity.RestaurantEntity;
import com.example.munchies.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private RestaurantMapper restaurantMapper;
    @Autowired
    GroupOrderMapper groupOrderMapper;

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

    @Transactional(rollbackFor = RestaurantWithActiveOrderException.class)
    public void deleteRestaurant(Integer id) throws RestaurantWithActiveOrderException, NotFoundException {
        List<GroupOrderEntity> groupOrders = restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Restaurant doesn't exist")).getGroupOrders();
        List<GroupOrderDTO> groupOrderDTOS = groupOrderMapper.mapGroupOrderEntityListToDtoList(groupOrders);
        restaurantRepository.deleteById(id);
        for(var groupOrderDto : groupOrderDTOS){
            if(groupOrderDto.isActive()){
                throw new RestaurantWithActiveOrderException("Cannot delete restaurant with active order");
            }
        }
    }
    public RestaurantDTO updateRestaurant(Integer id, RestaurantCreationDTO restaurantDTO) throws NotFoundException {
        RestaurantEntity restaurantToUpdate = restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Restaurant doesn't exist"));
        restaurantToUpdate = restaurantMapper.mapRestaurantUpdateDtoToEntities(restaurantToUpdate, restaurantDTO);
        RestaurantEntity restaurantResponse = restaurantRepository.save(restaurantToUpdate);
        return restaurantMapper.mapRestaurantEntityToRestaurantDto(restaurantResponse);
    }
}
