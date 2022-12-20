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
        return "order_timeout_410";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(GroupOrderDoesntExistException.class)
    public String handleGroupOrderDoesntExistException(GroupOrderDoesntExistException groupOrderDoesntExistException, Model model){
        model.addAttribute("error404", groupOrderDoesntExistException.getMessage());
        return "order_not_exist_404";
    }
}
