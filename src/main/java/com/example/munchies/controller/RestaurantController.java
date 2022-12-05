package com.example.munchies.controller;

import com.example.munchies.model.dto.DeliveryInfoDTO;
import com.example.munchies.model.dto.NewOrUpdateRestaurantDTO;
import com.example.munchies.model.dto.RestaurantDetailsDTO;
import com.example.munchies.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String saveRestaurant(@ModelAttribute("deliveryInfo") @Valid DeliveryInfoDTO deliveryInfoDTO,
                                 BindingResult bindingResult1,
                                 @ModelAttribute("newRestaurant") @Valid NewOrUpdateRestaurantDTO restaurantDTO,
                                 BindingResult bindingResult2){
        if(bindingResult1.hasErrors() || bindingResult2.hasErrors()){
            return "add_restaurant";
        }
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
    public String updateRestaurant(@PathVariable("id") Integer id,
                                   @ModelAttribute("updateRestaurant") @Valid NewOrUpdateRestaurantDTO restaurantDTO,
                                   BindingResult result1,
                                   @ModelAttribute("updateDeliveryInfo") @Valid DeliveryInfoDTO deliveryInfoDTO,
                                   BindingResult result2){
        if(result1.hasErrors() || result2.hasErrors()){
            return "update_restaurant";
        }
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
