package com.tutorial.spring.security.formlogin.model;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id", nullable=false, unique=true)
    private Integer cartId;

    @Column(name="cookie_session")
    private String cookieSession;

    @Column(name="status")
    private String status;

    @Column(name="user_id")
    private Integer userId;

    public Cart() {
    }

    public Cart(String cookieSession, String status, Integer userId) {
        this.cookieSession = cookieSession;
        this.status = status;
        this.userId = userId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getCookieSession() {
        return cookieSession;
    }

    public void setCookieSession(String cookieSession) {
        this.cookieSession = cookieSession;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", cookieSession='" + cookieSession + '\'' +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                '}';
    }
}
