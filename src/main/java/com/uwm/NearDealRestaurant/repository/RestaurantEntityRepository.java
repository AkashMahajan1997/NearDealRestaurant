package com.uwm.NearDealRestaurant.repository;


import com.uwm.NearDealRestaurant.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantEntityRepository extends JpaRepository<RestaurantEntity, String> {
    RestaurantEntity findByResName(String resName);
}
