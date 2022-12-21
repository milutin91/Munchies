package com.example.munchies.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandling {
    @ResponseStatus(HttpStatus.GONE)
    @ExceptionHandler(GroupOrderTimeoutException.class)
    public String handleOrderNotValidException(GroupOrderTimeoutException groupOrderTimeoutException, Model model){
        model.addAttribute("error410", groupOrderTimeoutException.getMessage());
        return "gone_410";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String handleGroupOrderDoesntExistException(NotFoundException notFoundException, Model model){
        model.addAttribute("error404", notFoundException.getMessage());
        return "not_found_404";
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(RestaurantWithActiveOrderException.class)
    public String handleDeleteRestaurantWithActiveOrder(RestaurantWithActiveOrderException restaurantWithActiveOrderException, Model model){
        model.addAttribute("error403", restaurantWithActiveOrderException.getMessage());
        return "forbidden_403";
    }
}
