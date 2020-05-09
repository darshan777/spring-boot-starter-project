package com.example.shoppingcart.model;


import java.util.ArrayList;
import java.util.List;


public class User {
    private int userId;
    private String userName;
    private String password;
    //private List<Item> userCart = new ArrayList<>();
    public User() {

    }

    public User(int userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    /*
        public List<Item> getUserCart() {
            return userCart;
        }

        public void setUserCart(List<Item> userCart) {
            this.userCart = userCart;
        }
        */
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
