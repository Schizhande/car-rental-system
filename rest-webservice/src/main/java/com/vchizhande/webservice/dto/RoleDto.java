package com.vchizhande.webservice.dto;

import com.vchizhande.webservice.model.Role;
import lombok.Data;

@Data
public class RoleDto {

    private Long id;

    private String name;

    private String description;

    public Role toRole(){
        return new Role(this.name, this.description);
    }
}
