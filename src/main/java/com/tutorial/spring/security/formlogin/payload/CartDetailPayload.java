package com.tutorial.spring.security.formlogin.payload;

public class CartDetailPayload {
    private Integer cartDetailId;
    private Integer productId;
    private Integer cartId;
    private Integer amount;

    private String status;

    @Override
    public String toString() {
        return "CartDetailPayload{" +
                "cartDetailId=" + cartDetailId +
                ", productId=" + productId +
                ", cartId=" + cartId +
                ", amount=" + amount +
                '}';
    }

    public CartDetailPayload(Integer productId, Integer cartId, Integer amount, String status) {
        this.productId = productId;
        this.cartId = cartId;
        this.amount = amount;
        this.status = status;
    }

    public CartDetailPayload() {
    }

    public Integer getCartDetailId() {
        return cartDetailId;
    }

    public void setCartDetailId(Integer cartDetailId) {
        this.cartDetailId = cartDetailId;
    }

    public String getStatuss() {
        return status;
    }

    public void setStatuss(String status) {
        this.status = status;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
