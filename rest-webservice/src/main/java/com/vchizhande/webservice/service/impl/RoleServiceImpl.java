package com.vchizhande.webservice.service.impl;


import com.vchizhande.webservice.dto.RoleDto;
import com.vchizhande.webservice.exception.RecordNotFoundException;
import com.vchizhande.webservice.model.Role;
import com.vchizhande.webservice.repository.RoleRepository;
import com.vchizhande.webservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findById(Long roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new RecordNotFoundException("Role with id " + roleId + " not found "));
    }

    @Override
    public Role create(RoleDto roleDto) {
        Role role = roleDto.toRole();
        return roleRepository.save(role);
    }

    @Override
    public Role update(RoleDto roleDto) {
        Role role = findById(roleDto.getId());
        role.setDescription(roleDto.getDescription());
        role.setName(roleDto.getName());
        return roleRepository.save(role);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Collection<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}
