package com.uwm.NearDealRestaurant.service;

import com.uwm.NearDealRestaurant.entity.UserInfo;
import com.uwm.NearDealRestaurant.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final UserInfoRepository userInfoRepository;

    public AdminService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public UserInfo addUser(UserInfo userInfo) {
     return   userInfoRepository.save(userInfo);
    }
}
