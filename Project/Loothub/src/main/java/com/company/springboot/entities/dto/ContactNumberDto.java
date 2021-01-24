/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.springboot.entities.dto;

import com.company.springboot.entities.ContactNumber;
import java.util.List;

/**
 *
 * @author Dim.Kasimatis
 */
public class ContactNumberDto {
    private List<ContactNumber> telNumber;

     
    public ContactNumberDto() {
    }
     
    public ContactNumberDto(List<ContactNumber> telNumber) {
        this.telNumber = telNumber;
    }

    public List<ContactNumber> getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(List<ContactNumber> telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContactNumberDto{telNumber=").append(telNumber);
        sb.append('}');
        return sb.toString();
    }
    
    
     
     
}
