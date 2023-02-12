package com.tutorial.spring.security.formlogin.controller;

import com.tutorial.spring.security.formlogin.model.User;
import com.tutorial.spring.security.formlogin.payload.CartDetailsPayload;
import com.tutorial.spring.security.formlogin.repository.CartRepository;
import com.tutorial.spring.security.formlogin.repository.UserRepository;
import com.tutorial.spring.security.formlogin.service.CartDetailService;
import com.tutorial.spring.security.formlogin.service.CartService;
import com.tutorial.spring.security.formlogin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartDetailService cartDetailService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @GetMapping(value = "/cart")
    public String cartDetail( Model model)  {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = authentication.getName();
        User userInform = userRepository.findByUsername(user).get();
        String userName = userInform.getAccountName();
        Integer userId = userInform.getUserId();
        List<CartDetailsPayload> cartDetail = cartDetailService.getCartDetail(userId);
        Double allAmount = cartDetailService.countTotal(cartDetail);
        model.addAttribute("cartDetails", cartDetail);
        model.addAttribute("allAmount", allAmount);
        model.addAttribute("userName", userName);
        model.addAttribute("amountProduct", cartDetail.size());
        return "cart";
    }
}
