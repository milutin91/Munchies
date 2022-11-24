package com.example.munchies;

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
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantName);
        restaurant.setRestaurantAddress(restaurantAddress);
        restaurant.setRestaurantPhoneNumber(restaurantPhoneNumber);
        restaurant.setRestaurantMenuUrl(restaurantMenuUrl);
        restaurant.setRestaurantCreated(LocalDateTime.now());
        restaurantRepository.save(restaurant);
        return "Restaurant Created";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }
}
