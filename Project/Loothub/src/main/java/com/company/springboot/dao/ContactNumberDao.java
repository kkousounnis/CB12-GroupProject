//package com.company.springboot.dao;
//
//import com.company.springboot.entities.ContactNumber;
//import com.company.springboot.repository.IContactNumberRepository;
//import java.util.List;
//import javax.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ContactNumberDao implements IContactNumberDao {
//
//    @Autowired
//    private IContactNumberRepository contactNumberRepository;
//    
//    @Override
//    public List<ContactNumber> listAll() {
//        return contactNumberRepository.findAll(); 
//    }
//
//    @Override
//    public ContactNumber save(ContactNumber contactNumber) {
//        return contactNumberRepository.save(contactNumber); 
//    }
//
//    @Override
//    public ContactNumber get(Long id) {
//        return contactNumberRepository.findById(id).get(); 
//    }
//
//    @Override
//    public void delete(Long id) {
//        try {
//        contactNumberRepository.deleteById(id);
//        } catch (EntityNotFoundException e) {
//           System.out.println("Role dao didnt find id to delete");
//        }
//    }
//
//    @Override
//    public void update(ContactNumber contactNumber) {
//        contactNumberRepository.save(contactNumber);
//    }
//    
//}
