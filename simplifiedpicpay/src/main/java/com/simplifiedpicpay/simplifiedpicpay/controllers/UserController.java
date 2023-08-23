package com.simplifiedpicpay.simplifiedpicpay.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplifiedpicpay.simplifiedpicpay.domain.user.User;
import com.simplifiedpicpay.simplifiedpicpay.dtos.UserDTO;
import com.simplifiedpicpay.simplifiedpicpay.services.UserService;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
        User newUser = userService.createUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.userService.getAllUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }
}
