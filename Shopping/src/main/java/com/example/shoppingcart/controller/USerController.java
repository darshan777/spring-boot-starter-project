package com.example.shoppingcart.controller;


import com.example.shoppingcart.model.User;
import com.example.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class USerController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{userId}")
    private ResponseEntity<?> getUser(@Valid @PathVariable(value="userId") int userId){
        User u = userService.getUser(userId);
        if(u!=null){
            return new ResponseEntity<>(u, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/user")
    private ResponseEntity<?> getAllUser(){
        List<User> userList = userService.getAllUser();
        if(userList.size()<1){
            return new ResponseEntity<>("No user Present", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }

    }

    @PostMapping("/user")
    private ResponseEntity<?> createUser( @RequestBody User user){
        User u = userService.createUSer(user);
        if(u!=null){
            return new ResponseEntity<>(u, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("User already present", HttpStatus.ALREADY_REPORTED);
        }
    }
}
