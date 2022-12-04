package com.example.munchies.controller;

import com.example.munchies.model.dto.DeliveryInfoDTO;
import com.example.munchies.model.dto.NewOrUpdateRestaurantDTO;
import com.example.munchies.model.dto.RestaurantDetailsDTO;
import com.example.munchies.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller

public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurant/add")
    public String addNewRestaurant(NewOrUpdateRestaurantDTO restaurantDTO, DeliveryInfoDTO deliveryInfoDTO, Model model) {
        model.addAttribute("newRestaurant", restaurantDTO);
        model.addAttribute("deliveryInfo", deliveryInfoDTO);
        return "add_restaurant";
    }

    @PostMapping("/restaurant/save")
    public String saveRestaurant(@Valid NewOrUpdateRestaurantDTO restaurantDTO, @Valid DeliveryInfoDTO deliveryInfoDTO){
        restaurantService.addRestaurant(restaurantDTO, deliveryInfoDTO);
        return "redirect:/restaurant/all";
    }

    @GetMapping("/restaurant/all")
    public String getAllRestaurants(Model model){
        model.addAttribute("restaurants", restaurantService.getAllRestaurants());
        return "restaurants";
    }

    @GetMapping("/restaurant-details/{id}")
    public String getRestaurantDetails(@PathVariable("id") Integer id, Model model){
        RestaurantDetailsDTO restaurantDetailsDto = restaurantService.findRestaurantDetails(id);
        model.addAttribute("restaurantDetails", restaurantDetailsDto);
        return "restaurant_details";
    }

    @GetMapping("/restaurant-delete/{id}")
    public String deleteRestaurant(@PathVariable("id") Integer id){
        restaurantService.deleteRestaurant(id);
        return "redirect:/restaurant/all";
    }

    @PostMapping("/restaurant-update/{id}")
    public String updateRestaurant(@PathVariable("id") Integer id, NewOrUpdateRestaurantDTO restaurantDTO, DeliveryInfoDTO deliveryInfoDTO){
        restaurantService.updateRestaurant(id, restaurantDTO, deliveryInfoDTO);
        return "redirect:/restaurant/all";
    }

    @GetMapping("/restaurant/update.form/{id}")
    public String updateForm(@PathVariable("id") Integer id, Model model, NewOrUpdateRestaurantDTO restaurantDTO, DeliveryInfoDTO deliveryInfoDTO) {
        model.addAttribute("id", id);
        model.addAttribute("updateRestaurant", restaurantDTO);
        model.addAttribute("updateDeliveryInfo", deliveryInfoDTO);
        return "update_restaurant";
    }
}
