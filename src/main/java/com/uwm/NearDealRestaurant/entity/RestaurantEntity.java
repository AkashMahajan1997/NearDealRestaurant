package com.uwm.NearDealRestaurant.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "RestaurantEntity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantEntity {

    @Id
    @Field("_id")
    private String resId;

    private String resName;

    private String resAddress;

    private String resCity;

    private String resState;

    private Integer pincode;

    private String email;

    private String password;
}
