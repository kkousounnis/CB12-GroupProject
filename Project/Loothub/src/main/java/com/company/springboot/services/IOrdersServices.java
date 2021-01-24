package com.company.springboot.services;

import com.company.springboot.entities.Orders;
import java.util.List;


public interface IOrdersServices {
    public List<Orders> listAll();
    public Orders save(Orders orders);
    public Orders get(int id);
    public void delete(int id);
    public void update(Orders orders);
    public Orders findByUserId(int userId);
    
}
