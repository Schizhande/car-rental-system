package com.vchizhande.rest_client.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class VehicleCategoryDto {

    private Long id;

    @NotBlank(message = "is required")
    private String categoryDescription;

    @NotBlank(message = "is required")
    private String categoryName;
}