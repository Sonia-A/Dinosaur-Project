package com.dino.dino.service;


import com.dino.dino.model.CustomerDetails;
import com.dino.dino.model.ShoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControllerFunction {

    @Autowired
    private EmailProvider emailProvider;

    public  String sendEmail(ShoppingCart shoppingCart) throws Exception {
         String message = emailProvider.sendEmail(shoppingCart,"order of Product");
        if(message.equals("email sent")) {
            return "email successfully sent";
        }else{
            throw new RuntimeException("error");
        }

    }
}
