package com.uwm.NearDealRestaurant.controller;

import com.uwm.NearDealRestaurant.entity.RestaurantEntity;
import com.uwm.NearDealRestaurant.service.AsyncService;
import com.uwm.NearDealRestaurant.service.RestaurantEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/restaurant")
public class RestaurantEntityController {

    @Autowired
    private RestaurantEntityService restaurantEntityService;

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/getByName/{resName}")
    public RestaurantEntity getRestaurantByName(@PathVariable String resName) {
        return restaurantEntityService.getRestaurantByName(resName);
    }

    @GetMapping("/getById/{resId}")
    public RestaurantEntity getRestaurantById(@PathVariable String resId) {
        return restaurantEntityService.getRestaurantById(resId);
    }


    @PostMapping("/addRestaurant")
    public ResponseEntity<?> saveRestaurant(@RequestBody RestaurantEntity restaurantEntity) {
        return new ResponseEntity<>(restaurantEntityService.addRestaurant(restaurantEntity), HttpStatus.CREATED);
    }

    @GetMapping("/run")
    public String runAsyncTask() {
        for (int i = 0; i < 5; i++) {
            asyncService.executeAsyncTask();

        }
        return "Final task";
    }



}


