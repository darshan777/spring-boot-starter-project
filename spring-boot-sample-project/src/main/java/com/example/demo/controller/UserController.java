package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList = userService.getAllUser();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable(value="id") int id){
        Optional<User> user = userService.getAUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user){
        if(userService.createUser(user)){
            return ResponseEntity.ok("User Created");
        }
        return new ResponseEntity<>("user Created", HttpStatus.CREATED);
    }

    @PutMapping("/user/{userName}")
    public ResponseEntity<String> updateUser(@Valid @RequestBody User user, @PathVariable(value="userName") int firstName){
        userService.updateUser(firstName, user);
        return ResponseEntity.ok("User Updated");
    }

    @DeleteMapping("/user/{userName}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "userName") String firstName){
        userService.deleteUser(firstName);
        return ResponseEntity.ok("User deleted");
    }


}
