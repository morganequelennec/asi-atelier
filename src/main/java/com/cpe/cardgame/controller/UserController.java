package com.cpe.cardgame.controller;

import com.cpe.cardgame.model.UserGame;
import com.cpe.cardgame.service.UserService;
import com.cpe.cardgame.utils.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseMessage<UserGame> createUser(UserGame userGame) {
        return this.userService.updateUser(userGame);
    }

    @GetMapping("/user/{id}")
    public ResponseMessage<UserGame> getUserById(@PathVariable("id") int id) {
         return this.userService.getUser(id);
    }

    // Other request mappings for CRUD operations or custom queries can be defined here
}