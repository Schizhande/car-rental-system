package com.vchizhande.rest_client.domain;


import lombok.Data;

import java.util.List;

@Data
public class Role {

    private Long id;

    private String name;

    private String description;

    private List<UserPermission> permissions;
}
