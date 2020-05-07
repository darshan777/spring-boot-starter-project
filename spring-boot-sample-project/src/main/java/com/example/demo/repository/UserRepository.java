package com.example.demo.repository;

import com.example.demo.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
        addData();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    private void addData(){
        for(int i=0; i<10; i++){
            String firstName = "user" + i;
            String lastName = "last";
            String email = "a"+i+"@abc.com";
            String password = "abc";
            User user = new User(firstName, lastName, email, password);
            this.userList.add(user);
        }
    }

}
