package com.example.munchies.controller;

import com.example.munchies.model.dto.NewRestaurantDTO;
import com.example.munchies.repository.RestaurantRepository;
import com.example.munchies.model.entity.RestaurantEntity;
import com.example.munchies.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller

public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurant/add")
    public String addNewRestaurant(@ModelAttribute NewRestaurantDTO restaurantDTO, Model model) {
        model.addAttribute("newRestaurant", restaurantDTO);
        restaurantService.addRestaurant(restaurantDTO);

        return "/restaurant/add";

    }

    @GetMapping("/restaurant/all")
    public String getAllRestaurants(Model model){
        model.addAttribute("restaurants", restaurantService.getAllRestaurants());
        return "/restaurants/add";
    }
}
