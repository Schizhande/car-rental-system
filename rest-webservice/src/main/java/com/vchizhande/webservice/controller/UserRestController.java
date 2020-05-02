package com.vchizhande.webservice.controller;


import com.vchizhande.webservice.dto.UserDto;
import com.vchizhande.webservice.model.User;
import com.vchizhande.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1/users")
public class UserRestController {

    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody UserDto userDto){
        return userService.create(userDto);
    }

    @PutMapping("/{id}")
    public  User update(@PathVariable Long id, @RequestBody UserDto userDto){
        userDto.setId(id);
        return userService.update(userDto);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping
    public Collection<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/details")
    public User getUserByUsername(@RequestParam String username){
        return userService.loadUserByUsername(username);
    }


}
