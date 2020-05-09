package com.example.shoppingcart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = ShoppingCartApplication.class)
@WebAppConfiguration
public abstract class UserTest {

    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    public void getUser(){
        String uri = "/user";

    }

}
