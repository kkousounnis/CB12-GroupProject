package com.company.springboot.controllers;

import com.company.springboot.entities.User;
import com.company.springboot.entities.dto.OrderDto;
import com.company.springboot.services.ProductImageService;
import com.company.springboot.services.ProductService;
import com.company.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
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

    @PostMapping("/order")
    public ModelAndView uploadImage(@ModelAttribute("orderDto") OrderDto orderDto,
            @CurrentSecurityContext(expression = "authentication?.name") String username) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(orderDto.getCountry() + "me lene gewrgio");
        System.out.println(orderDto.getProductId() + "productId");
        System.out.println(orderDto.getEmail());
        System.out.println(orderDto.getTelNumber());
        System.out.println(orderDto.getCountry());
        System.out.println(orderDto.getTelNumber());
        

        modelAndView.setViewName("dummyPage");
        return modelAndView;
    }

}
