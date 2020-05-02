package com.vchizhande.rest_client.dto;

import javax.validation.constraints.NotBlank;

public class PermissionDto {

    private Long id;

    @NotBlank(message = "is required")
    private String authority;

    @NotBlank(message = "is required")
    private String description;
}