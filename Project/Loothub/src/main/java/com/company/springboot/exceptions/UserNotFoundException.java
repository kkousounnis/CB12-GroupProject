/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.springboot.exceptions;

/**
 *
 * @author Dim.Kasimatis
 */
  public class UserNotFoundException extends Exception {

        public UserNotFoundException() {
        }

        public UserNotFoundException(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
