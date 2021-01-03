package com.company.springboot.entities.dto;

import com.company.springboot.entities.ContactNumber;
import java.util.Collection;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegistrationDto {

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
<<<<<<< HEAD
     
=======

    private List<ContactNumber> telNumber;

>>>>>>> kkousounnis
    public UserRegistrationDto() {

    }

    public UserRegistrationDto(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserRegistrationDto(String firstName, String lastName, String email, String password, List<ContactNumber> telNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.telNumber = telNumber;
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

}
