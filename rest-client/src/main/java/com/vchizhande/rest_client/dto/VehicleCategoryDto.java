package com.vchizhande.rest_client.dto;

import lombok.Data;

@Data
public class VehicleCategoryDto {

    private Long id;

    private String categoryDescription;

    private String categoryName;
}