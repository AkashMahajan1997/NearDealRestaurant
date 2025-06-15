package com.uwm.NearDealRestaurant.security;

import com.uwm.NearDealRestaurant.entity.UserInfo;
import com.uwm.NearDealRestaurant.entity.UserInfoDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Hardcoded example
        if (!"akashmahajan@gmail.com".equals(username)) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        UserInfo userDetail = new UserInfo(1, "akash", "akashmahajan@gmail.com", "pass", "ROLE_ADMIN");

        return new UserInfoDetails(userDetail);
    }


}