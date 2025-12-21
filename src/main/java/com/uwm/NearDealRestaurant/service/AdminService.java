package com.uwm.NearDealRestaurant.service;

import com.uwm.NearDealRestaurant.entity.UserInfo;
import com.uwm.NearDealRestaurant.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    private final UserInfoRepository userInfoRepository;

    public AdminService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public UserInfo addUser(UserInfo userInfo) {
     return   userInfoRepository.save(userInfo);
    }

    public Boolean getUserByEmail(String email) {
        return Optional.ofNullable(userInfoRepository.getUserInfoByEmail(email)).isEmpty();
    }
}
