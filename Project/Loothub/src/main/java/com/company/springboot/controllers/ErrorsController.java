/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.springboot.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author spika
 */
@Controller
public class ErrorsController implements ErrorController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorsController.class);

    @Override
    public String getErrorPath() {
        return "/error";
    }
    
    @RequestMapping("/error")
        public String HandleError(HttpServletRequest request, Model model){
            String errorPage = "error";
            String pageTitle = "Error";
            
            Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
            
            if(status != null){
                Integer statusCode = Integer.valueOf(status.toString());
                if(statusCode == HttpStatus.NOT_FOUND.value()){
                    pageTitle = "Page Not Found";
                    errorPage = "error/404";
                    LOGGER.error("Error 404");
                }else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
                    pageTitle = "Internal Server Error";
                    errorPage = "error/500";
                    LOGGER.error("Error 500");
                }else if(statusCode == HttpStatus.FORBIDDEN.value()){
                    pageTitle = "Forbidden Error";
                    errorPage = "error/403";
                    LOGGER.error("Error 403");
                }else if(statusCode == HttpStatus.UNAUTHORIZED.value()){
                    pageTitle = "Unauthorized";
                    errorPage = "error/401";
                    LOGGER.error("Error 401");
                }else if(statusCode == HttpStatus.BAD_GATEWAY.value()){
                    pageTitle = "Bad Gateway";
                    errorPage = "error/502";
                    LOGGER.error("Error 502");
                }else if(statusCode == HttpStatus.SERVICE_UNAVAILABLE.value()){
                    pageTitle = "Service Unavailable";
                    errorPage = "error/503";
                    LOGGER.error("Error 503");
                }else if(statusCode == HttpStatus.BAD_REQUEST.value()){
                    pageTitle = "Bad Request";
                    errorPage = "error/400";
                    LOGGER.error("Error 400");
                }
            }
            
            model.addAttribute("pageTitle", pageTitle);
            
            return(errorPage);
        }
    
    
}
