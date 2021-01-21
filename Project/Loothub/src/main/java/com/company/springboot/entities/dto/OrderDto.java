package com.company.springboot.entities.dto;

import com.company.springboot.entities.ContactNumber;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class OrderDto {

    @NotBlank(message = "Enter first Name")
    @Size(min = 6, max = 15)
    private String firstName;
    @NotBlank(message = "Enter last Name")
    private String lastName;

    @NotBlank(message = "Enter your email.")
    @Email(message = "Enter a valid email address.")
    private String email;

    @NotBlank(message = "Enter your password.")
    @Size(min = 6, max = 30)
    private String password;

    private List<ContactNumber> telNumber;

    private String country;
    private String city;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String comments;

    private Integer productId;

    public OrderDto() {
    }

    public OrderDto(String firstName, String lastName, String email, String password, List<ContactNumber> telNumber, String country, String city, String streetName, String streetNumber, String postalCode, String comments, Integer productId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.telNumber = telNumber;
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.comments = comments;
        this.productId = productId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ContactNumber> getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(List<ContactNumber> telNumber) {
        this.telNumber = telNumber;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderDto{firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", telNumber=").append(telNumber);
        sb.append(", country=").append(country);
        sb.append(", city=").append(city);
        sb.append(", streetName=").append(streetName);
        sb.append(", streetNumber=").append(streetNumber);
        sb.append(", postalCode=").append(postalCode);
        sb.append(", comments=").append(comments);
        sb.append(", productId=").append(productId);
        sb.append('}');
        return sb.toString();
    }

}
