package com.tutorial.spring.security.formlogin.repository;

import com.tutorial.spring.security.formlogin.model.Cart;
import com.tutorial.spring.security.formlogin.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {
    Optional<CartDetail> findByProductId(Integer productId);
    List<CartDetail> findByCartId(Integer cartId);
}
