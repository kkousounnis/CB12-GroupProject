package com.company.springboot.services;

import com.company.springboot.entities.ItemStatus;
import java.util.List;


public interface IItemStatusServise {
    public List<ItemStatus> listAll();
    public ItemStatus save(ItemStatus itemStatus);
    public ItemStatus get(int id);
    public void delete(int id);
    public void update(ItemStatus itemStatus);
     
    
}
