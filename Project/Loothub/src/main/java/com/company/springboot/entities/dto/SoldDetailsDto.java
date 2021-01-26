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
public class SoldDetailsDto {
    
    private int orderId;
    private String productName;
    private String trackingNumber;
    private UserAddress shippingAddress;
    private UserAddress billingAddress;
    private BigDecimal price;
    private String status;

    public SoldDetailsDto() {
    }

    public SoldDetailsDto(int orderId, String productName, String trackingNumber, UserAddress shippingAddress, UserAddress billingAddress, BigDecimal price, String status) {
        this.orderId = orderId;
        this.productName = productName;
        this.trackingNumber = trackingNumber;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.price = price;
        this.status = status;
    }

    public SoldDetailsDto(String productName, BigDecimal price) {
        this.productName = productName;
        this.price = price;
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SoldDetailsDto{orderId=").append(orderId);
        sb.append(", productName=").append(productName);
        sb.append(", trackingNumber=").append(trackingNumber);
        sb.append(", shippingAddress=").append(shippingAddress);
        sb.append(", billingAddress=").append(billingAddress);
        sb.append(", price=").append(price);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
       
    
}
