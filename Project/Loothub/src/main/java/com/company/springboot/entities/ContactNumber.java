package com.company.springboot.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_numbers")
public class ContactNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String telNumber;
    
    

    public ContactNumber() {
    }

    public ContactNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return  telNumber;
    }

    
    
    
    
    
    
    
    
    
    
    
}
