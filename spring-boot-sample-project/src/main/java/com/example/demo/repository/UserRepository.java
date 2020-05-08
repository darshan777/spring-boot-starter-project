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
            User user = new User();
            user.setFirstName("user" + i)  ;
            user.setLastName("Last");
            user.setEmail("a"+i+"@abc.com");
            user.setPassword("abc");

            this.userList.add(user);
        }
    }

}
