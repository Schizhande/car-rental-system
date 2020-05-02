package com.vchizhande.webservice.service;

import com.vchizhande.webservice.dto.RoleDto;
import com.vchizhande.webservice.model.Role;

import java.util.Collection;

public interface RoleService {

    Role findById(Long roleId);

    Role create(RoleDto roleDto);

    Role update(RoleDto roleDto);

    void delete(Long id);

    Collection<Role> findAllRoles();
}
