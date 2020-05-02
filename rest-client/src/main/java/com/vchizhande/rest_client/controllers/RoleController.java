package com.vchizhande.rest_client.controllers;

import com.vchizhande.rest_client.configuration.BuildRestTemplate;
import com.vchizhande.rest_client.dto.RoleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/roles/")
public class RoleController {

    @GetMapping("list")
    public String gatRoles(Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        RoleDto[] roles = restTemplate.getForObject("http://localhost:8081/v1/roles", RoleDto[].class);
        model.addAttribute("roles", roles);
        return "list-roles";
    }

    @GetMapping("add")
    public String addRoleForm(Model model) {
        model.addAttribute("role", new RoleDto());
        return "save-role";
    }

    @PostMapping("add")
    public String addRole(@Valid @ModelAttribute("role") RoleDto role, BindingResult result) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        if (result.hasErrors()) {
            return "save-role";
        }
        restTemplate.postForObject("http://localhost:8081/v1/roles",
                role,
                RoleDto.class);
        return "redirect:/roles/list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        RoleDto roleDto = restTemplate.getForObject("http://localhost:8081/v1/roles/{id}",
                RoleDto.class, id);
        model.addAttribute("role", roleDto);
        return "update-role";
    }

    @PostMapping("update/{id}")
    public String updateRole(@PathVariable long id, @Valid @ModelAttribute("role") RoleDto role,
                                 BindingResult result) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        if (result.hasErrors()) {
            role.setId(id);
            return "update-role";
        }
        restTemplate.put("http://localhost:8081/v1/roles/{id}",
                role,
                role.getId());
        return "redirect:/roles/list";
    }

    @GetMapping("delete/{id}")
    public String deleteRole(@PathVariable("id") long id) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        restTemplate.delete("http://localhost:8081/v1/roles/{id}",
                id);
        return "redirect:/roles/list";
    }

}
