package com.company.springboot.dao;

import com.company.springboot.entities.ItemStatus;
import com.company.springboot.repository.IItemStatusRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemStatusDao implements IItemStatusDao {
    
    @Autowired
    private IItemStatusRepository itemStatusRepository;

    @Override
    public List<ItemStatus> listAll() {
        return itemStatusRepository.findAll(); 
    }

    @Override
    public ItemStatus save(ItemStatus itemStatus) {
        return itemStatusRepository.save(itemStatus); 
    }

    @Override
    public ItemStatus get(Long id) {
        return itemStatusRepository.findById(id).get(); 
    }

    @Override
    public void delete(Long id) {
        try {
        itemStatusRepository.deleteById(id);
        } catch (EntityNotFoundException e) {
           System.out.println("Role dao didnt find id to delete");
        }
    }

    @Override
    public void update(ItemStatus itemStatus) {
        itemStatusRepository.save(itemStatus);
    }
    
     
    
}
