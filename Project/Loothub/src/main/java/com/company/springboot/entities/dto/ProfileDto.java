package com.company.springboot.entities.dto;

import com.company.springboot.entities.ContactNumber;
import com.company.springboot.entities.UserAddress;
import java.util.List;

public class ProfileDto {

    private String firstName;
    private String lastName;
    private String email;
    private List<ContactNumber> telNumber;
    private List<UserAddress> userAddress;

    public ProfileDto() {
    }

    public ProfileDto(String firstName, String lastName, String email, List<ContactNumber> telNumber, List<UserAddress> userAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telNumber = telNumber;
        this.userAddress = userAddress;
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

    public List<ContactNumber> getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(List<ContactNumber> telNumber) {
        this.telNumber = telNumber;
    }

    public List<UserAddress> getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(List<UserAddress> userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProfileDto{firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", email=").append(email);
        sb.append(", telNumber=").append(telNumber);
        sb.append(", userAddress=").append(userAddress);
        sb.append('}');
        return sb.toString();
    }

}
