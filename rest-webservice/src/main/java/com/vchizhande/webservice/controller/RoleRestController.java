package com.vchizhande.webservice.controller;


import com.vchizhande.webservice.dto.RoleDto;
import com.vchizhande.webservice.model.Role;
import com.vchizhande.webservice.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("v1/roles")
public class RoleRestController {

    private final RoleService roleService;

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public Role create(@RequestBody RoleDto roleDto){
        return roleService.create(roleDto);
    }

    @PutMapping("/{id}")
    public  Role update(@PathVariable Long id, @RequestBody RoleDto roleDto){
        roleDto.setId(id);
        return roleService.update(roleDto);
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id){
        return roleService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        roleService.delete(id);
    }

    @GetMapping
    public Collection<Role> getAllRoles(){
        return roleService.findAllRoles();
    }

}
