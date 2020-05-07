package com.example.demo.service;

import com.example.demo.pojo.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserService {


    private UserRepository userRepository = new UserRepository();

    public List<User> getAllUser(){
        List<User> userList = userRepository.getUserList();
        return userList;
    }

    public User getAUser(String name){
        List<User> userList = userRepository.getUserList();
        for(User u : userList){
            if(u.getFirstName().equalsIgnoreCase(name)){
                return u;
            }
        }
        return null;
    }

    public boolean createUser(User user){
        userRepository.getUserList().add(user);
        return true;
    }

    public User updateUser(String userName, User user){
        List<User> userList = userRepository.getUserList();
        for(User u : userList){
            if(u.getFirstName().equalsIgnoreCase(userName)){
                userRepository.getUserList().remove(u);
                userRepository.getUserList().add(user);
                return user;
            }
        }
        return null;
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
