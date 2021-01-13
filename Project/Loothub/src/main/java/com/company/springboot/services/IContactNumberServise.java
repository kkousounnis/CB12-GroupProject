package com.company.springboot.services;

import com.company.springboot.entities.ContactNumber;
import java.util.List;


public interface IContactNumberServise {
    public List<ContactNumber> listAll();
    public ContactNumber save(ContactNumber contactNumber);
    public ContactNumber get(Long id);
    public void delete(Long id);
    public void update(ContactNumber contactNumber);
    
}
