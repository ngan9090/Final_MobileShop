package com.tutorial.spring.security.formlogin.payload;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

public class CartDetailsPayload {
    private Integer cartDetailId;
    private Integer productId;
    private String productName;
    private Double productPrice;
    private Double productSum;
    private Integer amount;
    private String status;

    private String imgLink;

    public CartDetailsPayload() {
    }

    public CartDetailsPayload(Integer cartDetailId, Integer productId,
                              String productName, Double productPrice, Double productSum, Integer amount, String status, String imgLink) {
        this.cartDetailId = cartDetailId;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productSum = productSum;
        this.amount = amount;
        this.status = status;
        this.imgLink = imgLink;
    }

    @Override
    public String toString() {
        return "CartDetailsPayload{" +
                " cartDetailId=" + cartDetailId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productSum=" + productSum +
                ", amount=" + amount +
                ", amount=" + status +
                ", status='" + imgLink + '\'' +
                '}';
    }


    public Integer getCartDetailId() {
        return cartDetailId;
    }

    public void setCartDetailId(Integer cartDetailId) {
        this.cartDetailId = cartDetailId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getProductSum() {
        return productSum;
    }

    public void setProductSum(Double productSum) {
        this.productSum = productSum;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
