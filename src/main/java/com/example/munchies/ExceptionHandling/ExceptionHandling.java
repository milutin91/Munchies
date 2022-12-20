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
}
