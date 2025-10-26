package com.uwm.NearDealRestaurant.service;

import com.uwm.NearDealRestaurant.entity.RestaurantEntity;
import com.uwm.NearDealRestaurant.repository.RestaurantEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantEntityService {

    private final RestaurantEntityRepository restaurantEntityRepository;

    public RestaurantEntity getRestaurantByName(String resName) {
        return restaurantEntityRepository.findByResName(resName);
    }

    public RestaurantEntity addRestaurant(RestaurantEntity restaurantEntity) {
        return restaurantEntityRepository.save(restaurantEntity);
    }


    public RestaurantEntity getRestaurantById(String id) {
        return restaurantEntityRepository.findById(id).get();
    }

    public RestaurantEntityService(RestaurantEntityRepository restaurantEntityRepository) {
        this.restaurantEntityRepository = restaurantEntityRepository;
    }
}
