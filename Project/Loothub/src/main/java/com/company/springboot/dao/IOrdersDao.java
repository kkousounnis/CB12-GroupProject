package com.company.springboot.dao;

import com.company.springboot.entities.Orders;
import java.util.List;


public interface IOrdersDao {
    public List<Orders> listAll();
    public Orders save(Orders orders);
    public Orders get(int id);
    public void delete(int id);
    public void update(Orders orders);
    
}
