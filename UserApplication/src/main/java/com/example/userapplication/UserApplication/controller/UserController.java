package com.example.userapplication.UserApplication.controller;

import com.example.userapplication.UserApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getMovieDetails",method = RequestMethod.GET)
    public String movieDetails(){
        return userService.getMovieDetails();
    }

}
