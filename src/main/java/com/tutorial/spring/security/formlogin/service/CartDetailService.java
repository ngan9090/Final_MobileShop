package com.tutorial.spring.security.formlogin.service;

import com.tutorial.spring.security.formlogin.model.Cart;
import com.tutorial.spring.security.formlogin.model.CartDetail;
import com.tutorial.spring.security.formlogin.payload.CartDetailPayload;
import com.tutorial.spring.security.formlogin.payload.CartDetailsPayload;
import com.tutorial.spring.security.formlogin.payload.CartPayload;

import java.util.List;

public interface CartDetailService {
    List<CartDetail> listCartDetail();

    void add(CartDetailPayload cartDetailPayLoad);

    List<CartDetailsPayload> getCartDetail(Integer userId);

    Double countTotal(List<CartDetailsPayload> CartDetailsPayload);
}
