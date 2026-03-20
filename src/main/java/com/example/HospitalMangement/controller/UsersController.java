package com.example.HospitalMangement.controller;

import com.example.HospitalMangement.entity.Users;
import com.example.HospitalMangement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users getRegister(@RequestBody Users users){
        return userService.getRegister(users);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users){
        return userService.login(users);
    }
}
