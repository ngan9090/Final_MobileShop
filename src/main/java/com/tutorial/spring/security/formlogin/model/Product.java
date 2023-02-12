package com.tutorial.spring.security.formlogin.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id", nullable=false, unique=true)
    private Integer productCode;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_description")
    private String productDescription;

    @Column(name="category_id")
    private Integer category_id;

    @Column(name="brand_id")
    private Integer brand_id;

    @Column(name="price")
    private Double buyPrice;

    @Column(name="img_link")
    private String productImageLink;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="discount")
    private Integer discount;

    public Product() {
    }

    public Product( String productName, String productDescription, Integer category_id,
                   Integer brand_id, double buyPrice, String productImageLink, Integer quantity, Integer discount) {

        this.productName = productName;
        this.productDescription = productDescription;
        this.category_id = category_id;
        this.brand_id = brand_id;
        this.buyPrice = buyPrice;
        this.productImageLink = productImageLink;
        this.quantity = quantity;
        this.discount = discount;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getProductImageLink() {
        return productImageLink;
    }

    public void setProductImageLink(String productImageLink) {
        this.productImageLink = productImageLink;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer quantity) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode=" + productCode +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", category_id=" + category_id +
                ", brand_id=" + brand_id +
                ", buyPrice=" + buyPrice +
                ", productImageLink='" + productImageLink + '\'' +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}