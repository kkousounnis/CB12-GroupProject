/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.springboot.entities.dto;

/**
 *
 * @author Dim.Kasimatis
 */
public class UserProfileDto {
    private UserDto userDto;
    private ContactNumberDto contactDto;
    private AddressDto addressDto;

    public UserProfileDto() {
    }

    public UserProfileDto(UserDto userDto, ContactNumberDto contactDto, AddressDto addressDto) {
        this.userDto = userDto;
        this.contactDto = contactDto;
        this.addressDto = addressDto;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public ContactNumberDto getContactDto() {
        return contactDto;
    }

    public void setContactDto(ContactNumberDto contactDto) {
        this.contactDto = contactDto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserProfileDto{userDto=").append(userDto);
        sb.append(", contactDto=").append(contactDto);
        sb.append(", addressDto=").append(addressDto);
        sb.append('}');
        return sb.toString();
    }
    
   
    
    
    
}
