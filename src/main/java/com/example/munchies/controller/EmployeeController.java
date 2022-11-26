package com.example.munchies.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employee")
    public String employee() {
        return "This is Home Page";
    }

    @GetMapping("/admin")
    public String admin() {
        return "This is Admin Page";
    }

    @GetMapping("/")
    public String home(){
        return "Home";
    }
}
