package com.uwm.NearDealRestaurant.service;

import com.uwm.NearDealRestaurant.entity.RestaurantEntity;
import com.uwm.NearDealRestaurant.repository.RestaurantEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantEntityService {

    @Autowired
    private RestaurantEntityRepository restaurantEntityRepository;

    public RestaurantEntity getRestaurantByName(String resName) {
        return restaurantEntityRepository.findByResName(resName);
    }

//    public RestaurantEntity addRestaurant(RestaurantEntity restaurantEntity) {
//        return restaurantEntityRepository.save(new RestaurantEntity(restaurantEntity.getResId(),restaurantEntity.getResName()));
//    }


    public RestaurantEntity getRestaurantById(String resId) {
        return restaurantEntityRepository.findById(resId).get();
    }


}
