package com.uwm.NearDealRestaurant.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MenuEntity")
public class MenuEntity {

    private String menuId;

    private String menuType;

    private RestaurantEntity restaurantEntity;
}
