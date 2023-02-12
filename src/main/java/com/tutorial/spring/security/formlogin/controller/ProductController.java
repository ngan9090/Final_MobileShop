package com.tutorial.spring.security.formlogin.controller;

import com.tutorial.spring.security.formlogin.model.Cart;
import com.tutorial.spring.security.formlogin.model.CartDetail;
import com.tutorial.spring.security.formlogin.model.Product;
import com.tutorial.spring.security.formlogin.model.User;
import com.tutorial.spring.security.formlogin.payload.CartDetailPayload;
import com.tutorial.spring.security.formlogin.payload.CartDetailsPayload;
import com.tutorial.spring.security.formlogin.payload.CartPayload;
import com.tutorial.spring.security.formlogin.payload.Paged;
import com.tutorial.spring.security.formlogin.repository.CartRepository;
import com.tutorial.spring.security.formlogin.repository.ProductRepository;
import com.tutorial.spring.security.formlogin.repository.UserRepository;
import com.tutorial.spring.security.formlogin.service.CartDetailService;
import com.tutorial.spring.security.formlogin.service.CartService;
import com.tutorial.spring.security.formlogin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductController {
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

    @GetMapping(value = "/")
    public String product(Model model)  {
        List<Product> productList = productService.listProduct();
        model.addAttribute("products", productList);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = authentication.getName();
        User userInform = userRepository.findByUsername(user).get();
        String userName = userInform.getAccountName();
        Integer userId = userInform.getUserId();

        Optional<Cart> find = cartRepository.findByUserId(userId);
        if(!find.isPresent()){
            Cart cart = new Cart("","new",userId);
            cartRepository.save(cart);}
        List<CartDetailsPayload> cartDetail = cartDetailService.getCartDetail(userId);
        Integer amountProduct = cartDetail.size();
        model.addAttribute("user", userName);
        model.addAttribute("userId", userId);
        model.addAttribute("amountProduct", amountProduct);
        model.addAttribute("allAmount", cartDetailService.countTotal(cartDetail));
        return "home";
    }

    @GetMapping(value = "/shop")
    public String postShop(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                        @RequestParam(value = "size", required = false, defaultValue = "20") int size, Model model) {
        Paged<Product> post = productService.getPage(pageNumber, size);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = authentication.getName();
        User userInform = userRepository.findByUsername(user).get();
        String userName = userInform.getAccountName();
        Integer userId = userInform.getUserId();
        List<Product> productList = productService.listProduct();
        List<CartDetailsPayload> cartDetail = cartDetailService.getCartDetail(userId);
        Integer amountProduct = cartDetail.size();
        model.addAttribute("posts",post );
        Double allAmount = cartDetailService.countTotal(cartDetail);
        model.addAttribute("cartDetail", cartDetail);
        model.addAttribute("allAmount", allAmount);
        model.addAttribute("products", productList);
        model.addAttribute("amountProduct", amountProduct);
        return "shop";
    }

    @GetMapping(value = "/details/{productCode}")
    public String productDetail(@PathVariable(value = "productCode") Integer productCode,Model model)  {
        List<Product> product = productService.productDetail(productCode);
        model.addAttribute("productDetail", product);
        List<Product> productList = productService.listProduct();
        model.addAttribute("products", productList);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = authentication.getName();
        User userInform = userRepository.findByUsername(user).get();
        Integer userId = userInform.getUserId();
        Cart find = cartRepository.findByUserId(userId).get();
        Integer cartId = find.getCartId();
        List<CartDetailsPayload> cartDetail = cartDetailService.getCartDetail(userId);
        Integer amountProduct = cartDetail.size();
        model.addAttribute("userId", userId);
        model.addAttribute("cartId", cartId);
        model.addAttribute("allAmount", cartDetailService.countTotal(cartDetail));
        model.addAttribute("amountProduct", amountProduct);
        return "productDetails";
    }

    @PostMapping("/addCart")
    public String addCart(@ModelAttribute CartDetailPayload payload) {
        cartDetailService.add(payload);
        return "redirect:shop";
    }

    @GetMapping(value = "/my")
    public String posts(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                        @RequestParam(value = "size", required = false, defaultValue = "20") int size, Model model) {
        Paged<Product> post = productService.getPage(pageNumber, size);
        model.addAttribute("posts",post );
        return "shop";
    }
}
