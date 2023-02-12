package com.tutorial.spring.security.formlogin.service;

import com.tutorial.spring.security.formlogin.model.Cart;
import com.tutorial.spring.security.formlogin.model.CartDetail;
import com.tutorial.spring.security.formlogin.model.Product;
import com.tutorial.spring.security.formlogin.payload.CartDetailPayload;
import com.tutorial.spring.security.formlogin.payload.CartDetailsPayload;
import com.tutorial.spring.security.formlogin.repository.CartDetailRepository;
import com.tutorial.spring.security.formlogin.repository.CartRepository;
import com.tutorial.spring.security.formlogin.repository.ProductRepository;
import com.tutorial.spring.security.formlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartDetailServiceImpl implements CartDetailService {
    @Autowired
    CartDetailRepository repository;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartDetailService cartDetailService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<CartDetail> listCartDetail() {
        return repository.findAll();
    }

    @Override
    public void add(CartDetailPayload cartDetailPayLoad){
         CartDetail cartDetail = new CartDetail(cartDetailPayLoad.getProductId(),cartDetailPayLoad.getCartId(),
                 cartDetailPayLoad.getAmount(), "new");
         repository.save(cartDetail);
    }

    @Override
    public List<CartDetailsPayload> getCartDetail(Integer userId){
        List<CartDetailsPayload> cartDetailsPayload = new ArrayList<>();
        Cart cart = cartRepository.findByUserId(userId).get();
        List<CartDetail> cartDetail = cartDetailRepository.findByCartId(cart.getCartId());
        if(!cartDetail.isEmpty()){
            for(int i = 0; i< cartDetail.size(); i++){
                CartDetailsPayload detail = cartDetailToCartDetailPayload(cartDetail.get(i));
                cartDetailsPayload.add(detail);
            }
        }
        return cartDetailsPayload;

    }

    public CartDetailsPayload cartDetailToCartDetailPayload(CartDetail cartDetail){
        Product product = productRepository.findByProductCode(cartDetail.getProductId()).get();
        Double productSum = (product.getBuyPrice()*(1-(product.getDiscount()/100)))*(cartDetail.getAmount());
        CartDetailsPayload cartDetailsPayload = new CartDetailsPayload(cartDetail.getCartDetailId(),
                cartDetail.getProductId(),product.getProductName(),product.getBuyPrice(),productSum,cartDetail.getAmount(),
                cartDetail.getStatuss(),product.getProductImageLink());
        return cartDetailsPayload;
    }
    @Override
    public Double countTotal(List<CartDetailsPayload> cartDetailsPayloads){
        Double sumAll = Double.valueOf(0);
        Double element;
        if(!cartDetailsPayloads.isEmpty()){
            for(int i = 0; i< cartDetailsPayloads.size(); i++){
                sumAll += cartDetailsPayloads.get(i).getProductSum();
            }
        }
        return sumAll;
    }
}
