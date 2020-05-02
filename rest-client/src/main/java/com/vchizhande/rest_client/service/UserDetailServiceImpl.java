package com.vchizhande.rest_client.service;

import com.vchizhande.rest_client.dto.UserDetailsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        log.info("----> Load user details for {}", name);
        RestTemplate restTemplate = new RestTemplate();

        UserDetails userDetails =  restTemplate.getForObject("http://localhost:8081/v1/users/details?username=" + name, UserDetailsDto.class);

        log.info("----> response {}", userDetails);
        new AccountStatusUserDetailsChecker().check(userDetails);

        return userDetails;

    }
}

