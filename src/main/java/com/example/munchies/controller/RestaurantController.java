package com.example.munchies.controller;

import com.example.munchies.repository.RestaurantRepository;
import com.example.munchies.model.entity.RestaurantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping(path = "/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewRestaurant(@RequestParam String restaurantName,
                                                 @RequestParam String restaurantAddress,
                                                 @RequestParam String restaurantPhoneNumber,
                                                 @RequestParam String restaurantMenuUrl) {
        RestaurantEntity restaurantEntity = new RestaurantEntity();
        restaurantEntity.setRestaurantName(restaurantName);
        restaurantEntity.setRestaurantAddress(restaurantAddress);
        restaurantEntity.setRestaurantPhoneNumber(restaurantPhoneNumber);
        restaurantEntity.setRestaurantMenuUrl(restaurantMenuUrl);
        restaurantEntity.setRestaurantCreated(LocalDateTime.now());
        restaurantRepository.save(restaurantEntity);
        return "Restaurant Created";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<RestaurantEntity> getAllRestaurants(){
        return restaurantRepository.findAll();
    }
}
