/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.springboot.entities.dto;

import com.company.springboot.entities.UserAddress;
import java.util.List;

/**
 *
 * @author Dim.Kasimatis
 */
public class AddressDto {
    private List<UserAddress> userAddress;
    
    public AddressDto() {
    }

    public AddressDto(List<UserAddress> userAddress) {
        this.userAddress = userAddress;
    }

    public List<UserAddress> getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(List<UserAddress> userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AddressDto{userAddress=").append(userAddress);
        sb.append('}');
        return sb.toString();
    }

 

    
    
    
}
