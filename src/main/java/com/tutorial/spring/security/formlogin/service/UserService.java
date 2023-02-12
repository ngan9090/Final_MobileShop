package com.tutorial.spring.security.formlogin.service;

import com.tutorial.spring.security.formlogin.model.Product;
import com.tutorial.spring.security.formlogin.payload.CartPayload;
import com.tutorial.spring.security.formlogin.payload.LoginPayload;
import com.tutorial.spring.security.formlogin.payload.RegisterPayload;

import java.awt.print.Pageable;
import java.util.List;

public interface UserService {
    void save(RegisterPayload payload);

}
