package com.company.springboot.services;

import com.company.springboot.dao.ContactNumberDao;
import com.company.springboot.entities.ContactNumber;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ContactNumberServise implements IContactNumberServise {

    @Autowired
    private ContactNumberDao contactNumberDao;
    
    @Override
    public List<ContactNumber> listAll() {
        return contactNumberDao.listAll(); 
    }

    @Override
    public ContactNumber save(ContactNumber contactNumber) {
        return contactNumberDao.save(contactNumber);
    }

    @Override
    public ContactNumber get(Long id) {
        return contactNumberDao.get(id); 
    }

    @Override
    public void delete(Long id) {
        try {
        contactNumberDao.delete(id);
        } catch (EntityNotFoundException e) {
           System.out.println("Role Servises didnt find id to delete");
        }
    }

    @Override
    public void update(ContactNumber contactNumber) {
        contactNumberDao.update(contactNumber);
    }
    
}
