package com.example.munchies.controller;

import com.example.munchies.model.dto.NewRestaurantDTO;
import com.example.munchies.model.dto.RestaurantDetailsDTO;
import com.example.munchies.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurant/add")
    public String addNewRestaurant(NewRestaurantDTO restaurantDTO, Model model) {
        model.addAttribute("newRestaurant", restaurantDTO);
        return "add_restaurant";
    }

    @PostMapping("/restaurant/save")
    public String saveRestaurant(NewRestaurantDTO restaurantDTO){
        restaurantService.addRestaurant(restaurantDTO);
        return "redirect:/restaurant/all";
    }

    @GetMapping("/restaurant/all")
    public String getAllRestaurants(Model model){
        model.addAttribute("restaurants", restaurantService.getAllRestaurants());
        return "restaurants";
    }

    @GetMapping("/restaurant-details/{id}")
    public String getRestaurantDetails(@PathVariable("id") Integer id, Model model){
        RestaurantDetailsDTO restaurantDetailsDTO = restaurantService.findRestaurantDetails(id);
        model.addAttribute("restaurantDetails", restaurantDetailsDTO);
        return "restaurant_details";
    }

}
