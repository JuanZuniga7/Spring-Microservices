package com.example.users.controller;

import com.example.users.dto.UserCredentials;
import com.example.users.model.User;
import com.example.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestParam(name="userId") long userId) {
        User user = userService.getUser(userId);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/user/login")
    public ResponseEntity<User> loginUser(@RequestBody UserCredentials user) {
        try {
            User loggedInUser = userService.loginUser(user);
            return new ResponseEntity<User>(loggedInUser, HttpStatus.OK);
        }catch (RuntimeException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

}
