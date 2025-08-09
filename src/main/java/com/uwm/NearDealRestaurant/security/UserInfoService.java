package com.uwm.NearDealRestaurant.security;

import com.uwm.NearDealRestaurant.entity.UserInfo;
import com.uwm.NearDealRestaurant.entity.UserInfoDetails;
import com.uwm.NearDealRestaurant.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    UserInfoRepository userInfoRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        UserInfo userInfo = userInfoRepository.getUserInfoByEmail(username);
//        if (!"akashmahajan@gmail.com".equals(username)) {
//            throw new UsernameNotFoundException("User not found: " + username);
//        }
//
//        UserInfo userDetail = new UserInfo(1, "akash", "akashmahajan@gmail.com", "pass", "ROLE_ADMIN");
        if (userInfo == null) {
            System.out.println("User 404");
            throw new UsernameNotFoundException("User 404");
        }
        return new UserInfoDetails(userInfo);
    }


}