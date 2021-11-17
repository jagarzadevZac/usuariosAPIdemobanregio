package com.UserManagement.UserManagement.dto;


import org.springframework.lang.NonNull;


public class UserDto {

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;

    
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
    

    
}
