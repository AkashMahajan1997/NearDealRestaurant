package com.uwm.NearDealRestaurant.controller;

import com.uwm.NearDealRestaurant.entity.AuthRequest;
import com.uwm.NearDealRestaurant.entity.RestaurantEntity;
import com.uwm.NearDealRestaurant.entity.UserInfo;
import com.uwm.NearDealRestaurant.repository.UserInfoRepository;
import com.uwm.NearDealRestaurant.security.JwtService;
import com.uwm.NearDealRestaurant.service.AdminService;
import com.uwm.NearDealRestaurant.service.AsyncService;
import com.uwm.NearDealRestaurant.service.RestaurantEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@CrossOrigin(origins = "http://localhost:5173")
public class RestaurantEntityController {


    private final RestaurantEntityService restaurantEntityService;
    private final AsyncService asyncService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    private final AdminService adminService;

    public RestaurantEntityController(RestaurantEntityService restaurantEntityService, AsyncService asyncService, AuthenticationManager authenticationManager, JwtService jwtService, AdminService adminService) {
        this.restaurantEntityService = restaurantEntityService;
        this.asyncService = asyncService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.adminService = adminService;
    }

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

    @PostMapping("/login")
    public String loginTest(@RequestBody AuthRequest authRequest) {
        if (authRequest.getPassword().isEmpty() || authRequest.getUsername().isEmpty())
            return "fail";
        else
            return "success";

    }

    @PostMapping("/addUser")
    public UserInfo creteUser(@RequestBody UserInfo userInfo) {
        return adminService.addUser(userInfo);
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}






