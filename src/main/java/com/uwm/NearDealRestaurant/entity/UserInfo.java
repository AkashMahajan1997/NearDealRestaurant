package com.uwm.NearDealRestaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserInfo {


    @Id
    private String email;

    private String name;

    private String password;

    private String roles;

    public UserInfo(String email, String name, String password, String roles) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public UserInfo() {
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRoles() {
        return roles;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}