package com.company.springboot.dao;

import com.company.springboot.entities.Orders;
import com.company.springboot.entities.Product;
import com.company.springboot.repository.IOrdersRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersDao implements IOrdersDao {
    
    @Autowired
    private IOrdersRepository ordersRepository;
    
    @Override
    public List<Orders> listAll() {
        return ordersRepository.findAll(); 
    }

    @Override
    public Orders save(Orders orders) {
        return ordersRepository.save(orders); 
    }

    @Override
    public Orders get(int id) {
        return ordersRepository.findById(id).get(); 
    }

    @Override
    public void delete(int id) {
        try {
        ordersRepository.deleteById(id);
        } catch (EntityNotFoundException e) {
           System.out.println("Orders dao didnt find id to delete");
        }
    }

    @Override
    public void update(Orders orders) {
        ordersRepository.save(orders);
    }
    
    public Orders findByProductId(Product productId) {
            
    return ordersRepository.findByProductId(productId);
    
    }
    
}
