package com.example.shoppingcart.service;

import com.example.shoppingcart.model.User;
import com.example.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(int userId){
        for(User user : userRepository.getUserList()){
            if(user.getUserId() == userId){
                return user;
            }

        }
        return null;
    }

    public List<User> getAllUser(){
        return userRepository.getUserList();
    }

    public User createUSer(User user){
        if(userRepository.getUserList().contains(user)){
            return null;
        }else{
            userRepository.getUserList().add(user);
            return user;
        }
    }
}
