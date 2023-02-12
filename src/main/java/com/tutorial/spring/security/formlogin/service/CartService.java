package com.tutorial.spring.security.formlogin.service;

import com.tutorial.spring.security.formlogin.model.Cart;
import com.tutorial.spring.security.formlogin.payload.CartPayload;

import java.util.List;

public interface CartService {
    List<Cart> listCart();

    void add(CartPayload cartPayLoad);
}
