package com.uwm.NearDealRestaurant.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Entity
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String resName;

    private String resAddress;

    private String resCity;

    private String resState;

    private Integer pincode;

    private String email;

    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        this.resAddress = resAddress;
    }

    public String getResCity() {
        return resCity;
    }

    public void setResCity(String resCity) {
        this.resCity = resCity;
    }

    public String getResState() {
        return resState;
    }

    public void setResState(String resState) {
        this.resState = resState;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
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

    public RestaurantEntity(String id, String resName, String resAddress, String resCity, String resState, Integer pincode, String email, String password) {
        this.id = id;
        this.resName = resName;
        this.resAddress = resAddress;
        this.resCity = resCity;
        this.resState = resState;
        this.pincode = pincode;
        this.email = email;
        this.password = password;
    }

    public RestaurantEntity() {
    }
}
