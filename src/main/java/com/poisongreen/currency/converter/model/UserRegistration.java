package com.poisongreen.currency.converter.model;

import com.poisongreen.currency.converter.validation.PasswordMatches;
import com.poisongreen.currency.converter.validation.ValidEmail;
import com.poisongreen.currency.converter.validation.ValidPassword;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@PasswordMatches
public class UserRegistration {

    @NotNull(message = "{message.lastName.required}")
    @Size(min = 1)
    private String surname;

    @NotNull(message = "{message.firstName.required}")
    @Size(min = 1)
    private String firstName;

    @NotNull(message = "{message.login.required}")
    @Size(min = 1)
    private String login;

    @NotNull(message = "{message.password.required}")
    @ValidPassword
    private String password;

    @NotNull(message = "{message.passwordConfirm.required}")
    @Size(min = 1)
    private String passwordConfirm;

    @NotNull(message = "{message.email.required}")
    @Size(min = 1)
    @ValidEmail
    private String email;

    @DateTimeFormat(pattern="dd.MM.yyyy")
    private Date birthDate;

    private String street;

    private String zipcode;

    private String city;

    private String country;

   public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
