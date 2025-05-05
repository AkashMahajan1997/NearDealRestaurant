package com.uwm.NearDealRestaurant.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "RestaurantEntity")
@Data
public class RestaurantEntity {

    @Id
    @Field("_id")
    private String resId;

    private String resName;

    private String resLocation;
    public String getResId() {
        return resId;
    }

    public String getResName() {
        return resName;
    }

    public String getResLocation() {
        return resLocation;
    }

    public RestaurantEntity(String resId, String resName, String resLocation) {
        this.resId = resId;
        this.resName = resName;
        this.resLocation = resLocation;
    }
}
