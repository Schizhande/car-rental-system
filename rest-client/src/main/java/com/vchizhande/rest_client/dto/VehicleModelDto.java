package com.vchizhande.rest_client.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class VehicleModelDto {

    private Long id;

    @NotBlank(message = "is required")
    private String manufacturer;

    @NotBlank(message = "is required")
    private String modelName;

}