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
public class UserAddressDto {

    private String country;
    private String city;
    private String streetName;
    private String streetNumber;
    private String postalCode;

    public UserAddressDto() {
    }

    public UserAddressDto(String country, String city, String streetName, String streetNumber, String postalCode) {
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserAddressDto{country=").append(country);
        sb.append(", city=").append(city);
        sb.append(", streetName=").append(streetName);
        sb.append(", streetNumber=").append(streetNumber);
        sb.append(", postalCode=").append(postalCode);
        sb.append('}');
        return sb.toString();
    }
    
    

}
