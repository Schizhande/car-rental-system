package com.vchizhande.rest_client.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class VehicleDto {

    private Long id;

    @NotBlank(message = "is required")
    private String name;

    @NotBlank(message = "is required")
    private String color;

    @NotBlank(message = "is required")
    private String initialMileage;

    @NotBlank(message = "is required")
    private String registrationNumber;

    @NotNull(message = "is required")
    private Long categoryId;

    @NotNull(message = "is required")
    private Long modelId;

}