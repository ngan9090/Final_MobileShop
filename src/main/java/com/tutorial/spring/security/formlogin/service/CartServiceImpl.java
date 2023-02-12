package com.tutorial.spring.security.formlogin.service;

import com.tutorial.spring.security.formlogin.model.Cart;
import com.tutorial.spring.security.formlogin.model.Product;
import com.tutorial.spring.security.formlogin.payload.CartPayload;
import com.tutorial.spring.security.formlogin.repository.CartDetailRepository;
import com.tutorial.spring.security.formlogin.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartRepository repository;

    @Autowired
    CartDetailRepository cartDetailRepository;


    @Override
    public List<Cart> listCart() {
        return repository.findAll();
    }

    @Override
    public void add(CartPayload cartPayLoad){
        Cart cart = new Cart(cartPayLoad.getCookieSession(),"new",cartPayLoad.getUserId());
        repository.save(cart);
    }
}
