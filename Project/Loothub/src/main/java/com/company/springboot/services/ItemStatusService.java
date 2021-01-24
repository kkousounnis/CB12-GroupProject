package com.company.springboot.services;

import com.company.springboot.dao.ItemStatusDao;
import com.company.springboot.entities.ItemStatus;
import com.company.springboot.repository.IItemStatusRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemStatusService implements IItemStatusServise {
    
    @Autowired
    private ItemStatusDao itemStatusDao;
    
    @Override
    public List<ItemStatus> listAll() {
        return itemStatusDao.listAll(); 
    }

    @Override
    public ItemStatus save(ItemStatus itemStatus) {
        return itemStatusDao.save(itemStatus); 
    }

    @Override
    public ItemStatus get(Long id) {
        return itemStatusDao.get(id); 
    }

    @Override
    public void delete(Long id) {
        try {
        itemStatusDao.delete(id);
        } catch (EntityNotFoundException e) {
           System.out.println("Role Servises didnt find id to delete");
        }
    }

    @Override
    public void update(ItemStatus itemStatus) {
        itemStatusDao.update(itemStatus);
    }
    
   
    
}
