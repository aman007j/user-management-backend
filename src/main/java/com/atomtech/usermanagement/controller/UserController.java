package com.atomtech.usermanagement.controller;

import com.atomtech.usermanagement.dto.UserRequest;
import com.atomtech.usermanagement.entities.User;
import com.atomtech.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() { // get all the users
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest) {  // create a new user
        if (userRequest.getFirstName() == null || userRequest.getFirstName().trim().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (userRequest.getLastName() == null || userRequest.getLastName().trim().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User createdUser = userService.createUser(
                userRequest.getFirstName().trim(),
                userRequest.getLastName().trim()
        );

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
