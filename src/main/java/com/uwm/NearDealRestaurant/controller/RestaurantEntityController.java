package com.uwm.NearDealRestaurant.controller;

import com.uwm.NearDealRestaurant.entity.AuthRequest;
import com.uwm.NearDealRestaurant.entity.RestaurantEntity;
import com.uwm.NearDealRestaurant.security.JwtService;
import com.uwm.NearDealRestaurant.service.AsyncService;
import com.uwm.NearDealRestaurant.service.RestaurantEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin(origins = "http://localhost:5173")
public class RestaurantEntityController {

    @Autowired
    private RestaurantEntityService restaurantEntityService;

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtService jwtService;


    @GetMapping("/getByName/{resName}")
    public RestaurantEntity getRestaurantByName(@PathVariable String resName) {
        return restaurantEntityService.getRestaurantByName(resName);
    }

    @GetMapping("/getById/{resId}")
    public RestaurantEntity getRestaurantById(@PathVariable String resId) {
        return restaurantEntityService.getRestaurantById(resId);
    }


//    @PostMapping("/addRestaurant")
//    public ResponseEntity<?> saveRestaurant(@RequestBody RestaurantEntity restaurantEntity) {
//        return new ResponseEntity<>(restaurantEntityService.addRestaurant(restaurantEntity), HttpStatus.CREATED);
//    }

    @GetMapping("/run")
    public String runAsyncTask() {
        for (int i = 0; i < 5; i++) {
            asyncService.executeAsyncTask();

        }
        return "Final task";
    }

    @GetMapping("/login")
    public String loginTest(@RequestParam String email, @RequestParam String password) {
        if (email.isEmpty() || password.isEmpty())
            return "fail";
        else
            return "success";

    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}






