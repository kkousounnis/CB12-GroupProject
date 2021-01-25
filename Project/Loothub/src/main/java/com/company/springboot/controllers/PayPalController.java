package com.company.springboot.controllers;

import com.company.springboot.entities.ItemStatus;
import com.company.springboot.entities.Orders;
import com.company.springboot.entities.User;
import com.company.springboot.entities.dto.OrderDto;
import com.company.springboot.services.ItemStatusService;
import com.company.springboot.services.OrdersService;
import com.company.springboot.services.ProductImageService;
import com.company.springboot.services.ProductService;
import com.company.springboot.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PayPalController {

    @Autowired
    private ItemStatusService itemStatusService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private ProductService productService;
    
    @PostMapping("/paypal")
    public ModelAndView orderProduct(@ModelAttribute("orderDto") OrderDto orderDto,
            @CurrentSecurityContext(expression = "authentication?.name") String username) {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView = checkUser(modelAndView, username, user);
        modelAndView = setImageProduct(modelAndView, orderDto);

        List<Orders> orders = new ArrayList<>();
        modelAndView.addObject("orderDto", orderDto);
        modelAndView.setViewName("buy");
        modelAndView.addObject("succesbuymessage", "Succesfull");
        orders = ordersService.listAll();

        for (Orders order : orders) {
            
            if(order.getUserId().getId().equals(userService.findByEmailAddress(orderDto.getEmail()).getId())){
                System.out.println(order.getUserId());
                System.out.println(userService.findByEmailAddress(orderDto.getEmail()).getId());
                System.out.println(order.getProductId());
                System.out.println("*********");
                if(order.getProductId().getId().equals(orderDto.getProductId())){
                    System.out.println("(((((((((((((");
                    ItemStatus itemStatus = new ItemStatus(order.getItemStatusId().getId(), 
                                            "Sold");
                    itemStatusService.update(itemStatus);
                    
                }
               
                
            }
        }

        return (modelAndView);
    }

    public ModelAndView checkUser(ModelAndView modelAndView,
            String userName,
            User user) {
        if (userName.equals("anonymousUser")) {

            user.setEmail(null);
            modelAndView.addObject("user", user);
        } else {
            modelAndView.addObject("user", userService.findByEmailAddress(userName));
        }

        return (modelAndView);
    }

    public ModelAndView setImageProduct(ModelAndView modelAndView,
            OrderDto orderDto) {

        modelAndView.addObject("imageInfo",
                productImageService.findByProductId(productService.get(orderDto.getProductId())));
        modelAndView.addObject("imagePath",
                "/img/products/" + productImageService.findByProductId(productService.get(orderDto.getProductId())).getFileName());
        modelAndView.addObject("productId",
                orderDto.getProductId());
        modelAndView.addObject("productName",
                productService.get(orderDto.getProductId()).getName());

        modelAndView.addObject("productPrice",
                productService.get(orderDto.getProductId()).getPrice());

        return (modelAndView);
    }

}
