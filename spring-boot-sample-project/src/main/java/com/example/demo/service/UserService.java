package com.example.demo.service;

import com.example.demo.pojo.User;
import com.example.demo.repository.UserRRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserService {
    @Autowired
    private UserRRepository userRRepository;
    private UserRepository userRepository = new UserRepository();

    public List<User> getAllUser(){
        List<User> userList = userRRepository.findAll();
        return userList;
    }

    public Optional<User> getAUser(int id){
        Optional<User> u = userRRepository.findById(id);

        return u;
    }

    public boolean createUser(User user){
        userRRepository.save(user);
        return true;
    }

    public boolean updateUser(int userId, User user){
        return true;
    }

    public boolean deleteUser(String userName){
        List<User> userList = userRepository.getUserList();
        for(User u : userList){
            if(u.getFirstName().equalsIgnoreCase(userName)){
                userRepository.getUserList().remove(u);
                return true;
            }
        }
        return false;
    }
}
