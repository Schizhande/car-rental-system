package com.vchizhande.rest_client.dto;

import lombok.Data;

@Data
public class VehicleDto {

    private Long id;

    private String color;

    private String initialMileage;

    private String registrationNumber;

    private Long categoryId;

    private Long modelId;

}