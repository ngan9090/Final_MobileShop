package com.tutorial.spring.security.formlogin.model;


import javax.persistence.*;

@Entity
@Table(name = "cart_detail")
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_detail_id", nullable=false, unique=true)
    private Integer cartDetailId;

    @Column(name="product_id")
    private Integer productId;

    @Column(name="cart_id")
    private Integer cartId;

    @Column(name="amount")
    private Integer amount;

    @Column(name="status")
    private String status;

    public CartDetail(Integer productId, Integer cartId, Integer amount, String status) {
        this.productId = productId;
        this.cartId = cartId;
        this.amount = amount;
        this.status = status;
    }

    public CartDetail() {
    }

    @Override
    public String toString() {
        return "CartDetailPayload{" +
                "cartDetailId=" + cartDetailId +
                ", productId=" + productId +
                ", cartId=" + cartId +
                ", amount=" + amount +
                '}';
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
