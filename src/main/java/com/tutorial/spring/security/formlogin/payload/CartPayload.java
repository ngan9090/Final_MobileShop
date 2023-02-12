package com.tutorial.spring.security.formlogin.payload;

import com.tutorial.spring.security.formlogin.model.CartDetail;

import java.util.List;

public class CartPayload {
    private Integer cartId;
    private String cookieSession;
    private String status;
    private Integer userId;
    public List<CartDetail> cartDetail;

    @Override
    public String toString() {
        return "CartPayload{" +
                "cartId=" + cartId +
                ", cookieSession='" + cookieSession + '\'' +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                ", cartDetail=" + cartDetail +
                '}';
    }

    public CartPayload( String cookieSession, String status, Integer userId, List<CartDetail> cartDetail) {
        this.cookieSession = cookieSession;
        this.status = status;
        this.userId = userId;
        this.cartDetail = cartDetail;
    }

    public CartPayload() {
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

    public List<CartDetail> getCartDetail() {
        return cartDetail;
    }

    public void setCartDetail(List<CartDetail> cartDetail) {
        this.cartDetail = cartDetail;
    }
}
