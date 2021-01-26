/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.springboot.entities.dto;

import com.company.springboot.entities.UserAddress;
import java.math.BigDecimal;

/**
 *
 * @author Dim.Kasimatis
 */
public class SellDetailsDto {
    
    
    private String productName;
    private String trackingNumber;
    private UserAddress shippingAddress;
    private UserAddress billingAddress;
    private BigDecimal price;
    private String status;

    public SellDetailsDto() {
    }

    public SellDetailsDto(String productName, String trackingNumber, UserAddress shippingAddress, UserAddress billingAddress, BigDecimal price, String status) {
        this.productName = productName;
        this.trackingNumber = trackingNumber;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.price = price;
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public UserAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(UserAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public UserAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(UserAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
