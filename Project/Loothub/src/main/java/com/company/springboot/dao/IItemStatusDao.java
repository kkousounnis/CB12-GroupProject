package com.company.springboot.dao;

import com.company.springboot.entities.ItemStatus;
import java.util.List;


public interface IItemStatusDao {
    public List<ItemStatus> listAll();
    public ItemStatus save(ItemStatus itemStatus);
    public ItemStatus get(Long id);
    public void delete(Long id);
    public void update(ItemStatus itemStatus);
    
}
