/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.springboot.entities.dto;

import java.math.BigDecimal;

/**
 *
 * @author Dim.Kasimatis
 */
public class SellDetailsDto {
    
    
    private String productName;
    private BigDecimal price;

    public SellDetailsDto() {
    }


    public SellDetailsDto(String productName, BigDecimal price) {
        this.productName = productName;
        this.price = price;
    }
      


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SellDetailsDto{productName=").append(productName);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

}
