package com.tutorial.spring.security.formlogin.controller;

import com.tutorial.spring.security.formlogin.model.Product;
import com.tutorial.spring.security.formlogin.model.User;
import com.tutorial.spring.security.formlogin.payload.CartPayload;
import com.tutorial.spring.security.formlogin.payload.LoginPayload;
import com.tutorial.spring.security.formlogin.payload.RegisterPayload;
import com.tutorial.spring.security.formlogin.repository.UserRepository;
import com.tutorial.spring.security.formlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
public class AuthenticationController {

    @Autowired private UserService service;


    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpSession session) {
        session.setAttribute("error", getErrorMessage(request));
        return "login";
    }

//    @GetMapping("/login/{username}")
//    public String login(@PathVariable(value = "username") String username, Model model,HttpServletRequest request, HttpSession session) {
//        User user = userRepository.findByUsername(username).get();
//        model.addAttribute("user", user);
//        return "home";
//    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated())
            new SecurityContextLogoutHandler().logout(request, response, auth);
        return "redirect:login";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterPayload payload) {
        service.save(payload);

        return "redirect:login";
    }

//    @PostMapping("/login")
//    public String logins(@ModelAttribute LoginPayload payload) {
//        //if(Objects.nonNull(payload.getUsername())) {
//            String link = service.find(payload);
//
//      return link;
//
//    }


//    @GetMapping("/")
//    public String home(HttpServletRequest request, HttpSession session) {
//        return "home";
//    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }


    private String getErrorMessage(HttpServletRequest request) {
        Exception exception = (Exception) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        String error;
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }
        return error;
    }
}
