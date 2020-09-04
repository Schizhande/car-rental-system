package com.vchizhande.webservice.service.impl;

import com.vchizhande.webservice.dto.UserDto;
import com.vchizhande.webservice.exception.RecordNotFoundException;
import com.vchizhande.webservice.model.Role;
import com.vchizhande.webservice.model.User;
import com.vchizhande.webservice.repository.UserRepository;
import com.vchizhande.webservice.service.RoleService;
import com.vchizhande.webservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Collection<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public User create(UserDto userDto) {
        log.info("----> User request {}", userDto);
        Role role = roleService.findById(userDto.getRoleId());
        User user = userDto.toUser(passwordEncoder);
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public User update(UserDto userDto) {
        Role role = roleService.findById(userDto.getRoleId());
        User user = findById(userDto.getId());
        user.setRole(role);
        user.setAddress(userDto.getAddress());
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setUsername(userDto.getUsername());
        return userRepository.save(user);
    }

    @Override
    public User loadUserByUsername(String name) throws UsernameNotFoundException {
        log.info("### username {}", name);
        User user = userRepository.findByUsername(name)
                .orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));
        return user;

    }
}
