package com.uwm.NearDealRestaurant.repository;


import com.uwm.NearDealRestaurant.entity.RestaurantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantEntityRepository extends MongoRepository<RestaurantEntity, String> {
    RestaurantEntity findByResName(String resName);
}
