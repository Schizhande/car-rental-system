package com.vchizhande.rest_client.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RoleDto {

    private Long id;

    @NotBlank(message = "is required")
    private String name;

    @NotBlank(message = "is required")
    private String description;

}
