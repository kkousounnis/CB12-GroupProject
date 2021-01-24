package com.company.springboot.controllers;

import com.company.springboot.entities.ItemStatus;
import com.company.springboot.entities.Orders;
import com.company.springboot.entities.User;
import com.company.springboot.entities.UserAddress;
import com.company.springboot.entities.dto.OrderDto;
import com.company.springboot.entities.dto.UserRegistrationDto;
import com.company.springboot.services.ItemStatusService;
import com.company.springboot.services.OrdersService;
import com.company.springboot.services.ProductImageService;
import com.company.springboot.services.ProductService;
import com.company.springboot.services.UserAddressService;
import com.company.springboot.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductImageService productImageService;
    
    @Autowired
    private ItemStatusService itemStatusService;
    
    
    @Autowired
    private UserAddressService userAddressService;
    
    @Autowired
    private OrdersService orderService;

    @RequestMapping("/order/{id}")
    public ModelAndView showOrder(@PathVariable Integer id, @CurrentSecurityContext(expression = "authentication?.name") String username) {
        ModelAndView modelAndView = new ModelAndView();
        OrderDto orderDto = new OrderDto();
        orderDto.setProductId(id);
        modelAndView.addObject("orderDto", orderDto);

        if (username.equals("anonymousUser")) {
            User user = new User();
            user.setEmail(null);
            modelAndView.addObject("user", user);
            modelAndView.addObject("username", "");

        } else {
            modelAndView.addObject("user", userService.findByEmailAddress(username));
            orderDto.setFirstName(userService.findByEmailAddress(username).getFirstName());
            orderDto.setLastName(userService.findByEmailAddress(username).getLastName());
            orderDto.setEmail(userService.findByEmailAddress(username).getEmail());
            modelAndView.addObject("username", userService.findByEmailAddress(username).getEmail());

        }
        modelAndView.addObject("imageInfo", productImageService.findByProductId(productService.get(id)));
        modelAndView.addObject("imagePath", "/img/products/" + productImageService.findByProductId(productService.get(id)).getFileName());

        modelAndView.addObject("productId", id);
        modelAndView.addObject("productName", productService.get(id).getName());
        System.out.println(productService.get(id).getPrice());
        modelAndView.addObject("productPrice", productService.get(id).getPrice());

        modelAndView.setViewName("order");

        return modelAndView;
    }

    @PostMapping("/buy")
    public ModelAndView orderProduct(@Valid @ModelAttribute("orderDto") OrderDto orderDto,
            @CurrentSecurityContext(expression = "authentication?.name") String username,
            BindingResult bindingResult, ModelMap modelMap) {
        User user = new User();
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("orderDto", orderDto);
        
        
        if (username.equals("anonymousUser")) {
            
            user.setEmail(null);
            modelAndView.addObject("user", user);
        } else {
            modelAndView.addObject("user", userService.findByEmailAddress(username));
        }
        modelAndView.addObject("imageInfo", productImageService.findByProductId(productService.get(orderDto.getProductId())));
        modelAndView.addObject("imagePath", "/img/products/" + productImageService.findByProductId(productService.get(orderDto.getProductId())).getFileName());
        modelAndView.addObject("productId", orderDto.getProductId());
        modelAndView.addObject("productName", productService.get(orderDto.getProductId()).getName());

        modelAndView.addObject("productPrice", productService.get(orderDto.getProductId()).getPrice());

        if (bindingResult.hasErrors()) {
            
            modelAndView.setViewName("order");

        } else if (userService.findByEmailAddress(orderDto.getEmail()) != null && username.equals("anonymousUser")) {
            
            modelMap.addAttribute("message", "Username already exists.");
            modelAndView.addObject("Unsuccessful", "Unsuccessful Order Of Product");
            modelAndView.setViewName("order");
        } else {
            
            
            
            if(username.equals("anonymousUser")){
                
                UserRegistrationDto registrationDto = new UserRegistrationDto(
                    orderDto.getFirstName(),
                    orderDto.getLastName(),
                    orderDto.getEmail(),
                    orderDto.getPassword(),
                    orderDto.getTelNumber());
                user = userService.save(registrationDto);
            }else{
                user = userService.findByEmailAddress(username);
            }
            
            UserAddress userAddress = new UserAddress(
                    orderDto.getCountry(), 
                    orderDto.getCity(),
                    orderDto.getStreetName(),
                    orderDto.getStreetNumber(),
                    Integer.valueOf(orderDto.getPostalCode()),
                    true,
                    true,
                    user);
            
            userAddress = userAddressService.save(userAddress);
            
            ItemStatus itemStatus = new ItemStatus("Pending");
            
            itemStatus = itemStatusService.save(itemStatus);
            
            String trackingNumber = orderDto.getProductId()+
                    ""+user.getId();
            Orders order = new Orders(
                    orderDto.getComments(), 
                    trackingNumber, 
                    itemStatus, 
                    productService.get(orderDto.getProductId()),
                    userAddress,
                    userAddress,
                    user);
            orderService.save(order);
            modelAndView.setViewName("buy");
            modelAndView.addObject("succesmessage", "Succesfull");

        }

        return modelAndView;
    }

}
