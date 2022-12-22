package com.example.munchies.controller;

import com.example.munchies.ExceptionHandling.NotFoundException;
import com.example.munchies.ExceptionHandling.RestaurantWithActiveOrderException;
import com.example.munchies.model.dto.RestaurantCreationDTO;
import com.example.munchies.model.dto.RestaurantDTO;
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
    public String addNewRestaurant(RestaurantCreationDTO restaurantDTO, Model model) {
        model.addAttribute("newRestaurant", restaurantDTO);
        return "add_restaurant";
    }

    @PostMapping("/restaurant/save")
    public String saveRestaurant(@ModelAttribute("newRestaurant") @Valid RestaurantCreationDTO restaurantDTO,
                                 BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add_restaurant";
        }
        restaurantService.createRestaurant(restaurantDTO);
        return "redirect:/restaurant/all";
    }

    @GetMapping("/restaurant/all")
    public String getAllRestaurants(Model model){
        model.addAttribute("restaurants", restaurantService.getAllRestaurants());
        return "restaurants";
    }

    @GetMapping("/restaurant-details/{id}")
    public String getRestaurantDetails(@PathVariable("id") Integer id, Model model) throws NotFoundException {
        RestaurantDTO restaurantDto = restaurantService.findRestaurantDetails(id);
        model.addAttribute("restaurantDetails", restaurantDto);
        return "restaurant_details";
    }

    @GetMapping("/restaurant-delete/{id}")
    public String deleteRestaurant(@PathVariable("id") Integer id) throws RestaurantWithActiveOrderException, NotFoundException {
        restaurantService.deleteRestaurant(id);
        return "redirect:/restaurant/all";
    }

    @PostMapping("/restaurant-update/{id}")
    public String updateRestaurant(@PathVariable("id") Integer id,
                                   @ModelAttribute("updateRestaurant") @Valid RestaurantCreationDTO restaurantDTO,
                                   BindingResult result1) throws NotFoundException {
        if(result1.hasErrors()){
            return "update_restaurant";
        }
        restaurantService.updateRestaurant(id, restaurantDTO);
        return "redirect:/restaurant/all";
    }

    @GetMapping("/restaurant/update.form/{id}")
    public String updateForm(@PathVariable("id") Integer id, Model model, RestaurantCreationDTO restaurantDTO) throws NotFoundException {
        model.addAttribute("id", id);
        model.addAttribute("updateRestaurant", restaurantDTO);
        model.addAttribute("updateRestaurant", restaurantService.findRestaurantDetails(id));
        return "update_restaurant";
    }
}
