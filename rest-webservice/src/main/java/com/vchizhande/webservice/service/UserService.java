package com.vchizhande.webservice.service;

import com.vchizhande.webservice.dto.UserDto;
import com.vchizhande.webservice.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

public interface UserService {

    Collection<User> findAllUsers();

    void delete(Long id);

    User findById(Long id);

    User update(UserDto userDto);

    User create(UserDto userDto);

    User loadUserByUsername(String name) throws UsernameNotFoundException;
}
