package com.vchizhande.rest_client.controllers;

import com.vchizhande.rest_client.configuration.BuildRestTemplate;
import com.vchizhande.rest_client.dto.RoleDto;
import com.vchizhande.rest_client.dto.UserDetailsDto;
import com.vchizhande.rest_client.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/users/")
public class UserController {

    @GetMapping("list")
    public String gatUsers(Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        UserDetailsDto[] users = restTemplate.getForObject("http://localhost:8081/v1/users", UserDetailsDto[].class);
        model.addAttribute("users", users);
        return "list-users";
    }

    @GetMapping("add")
    public String addUserForm(Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        RoleDto[] roles = restTemplate.getForObject("http://localhost:8081/v1/roles", RoleDto[].class);
        model.addAttribute("roles", roles);
        model.addAttribute("user", new UserDto());
        return "save-user";
    }

    @PostMapping("add")
    public String addUser(@Valid @ModelAttribute("user")UserDto user, BindingResult result, Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        if (result.hasErrors()) {
            RoleDto[] roles = restTemplate.getForObject("http://localhost:8081/v1/roles", RoleDto[].class);
            model.addAttribute("roles", roles);
            return "save-user";
        }
        restTemplate.postForObject("http://localhost:8081/v1/users",
                user,
                UserDto.class);
        return "redirect:/users/list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        RoleDto[] roles = restTemplate.getForObject("http://localhost:8081/v1/roles", RoleDto[].class);
        model.addAttribute("roles", roles);
        UserDto userDto = restTemplate.getForObject("http://localhost:8081/v1/users/{id}",
                UserDto.class, id);
        model.addAttribute("user", userDto);
        return "update-user";
    }

    @PostMapping("update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid @ModelAttribute("user") UserDto user, BindingResult result, Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        if (result.hasErrors()) {
            user.setId(id);
            RoleDto[] roles = restTemplate.getForObject("http://localhost:8081/v1/roles", RoleDto[].class);
            model.addAttribute("roles", roles);
            return "update-user";
        }
        restTemplate.put("http://localhost:8081/v1/users/{id}",
                user,
                user.getId());
        return "redirect:/users/list";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        restTemplate.delete("http://localhost:8081/v1/users/{id}",
                id);
        return "redirect:/users/list";
    }

}
