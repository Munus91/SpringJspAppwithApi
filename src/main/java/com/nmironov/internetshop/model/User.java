package com.nmironov.internetshop.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


public class User {

    private long userId;
    @NotBlank(message = "User name cannot be blank")
    @Size(min = 3, max = 100, message = "Username must be between 3 and 100 characters")
    private String username;// user login
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;
    @NotBlank(message = "Surname cannot be blank")
    @Size(min = 3, max = 100, message = "Surname must be between 3 and 100 characters")
    private String surname;
    @Size(min = 5, message = "The password must contain at least 5 characters")
    private String password; //https://www.baeldung.com/spring-mvc-custom-validator
    private UserRole role;
    @NotBlank(message = "City cannot be blank")
    @Size(min = 3, max = 100, message = "City must be between 3 and 100 characters")
    private String city;
    @NotBlank(message = "AddressLine1 cannot be blank")
    @Size(min = 3, max = 1000, message = "AddressLine1 must be between 3 and 100 characters")
    private String addressLine1;//street address,company name
    @NotBlank(message = "AddressLine2 cannot be blank")
    @Size(min = 3, max = 1000, message = "AddressLine2 must be between 3 and 100 characters")
    private String addressLine2;//apartment,suite,building,floor
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private boolean archived;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() { return city; }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }


}

