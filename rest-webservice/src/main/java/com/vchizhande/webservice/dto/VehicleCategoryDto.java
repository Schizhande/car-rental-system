package com.vchizhande.webservice.dto;

import com.vchizhande.webservice.model.VehicleCategory;
import lombok.Data;

@Data
public class VehicleCategoryDto {

    private Long id;

    private String categoryDescription;

    private String categoryName;

    public VehicleCategory toVehicleCategory() {
        return new VehicleCategory(categoryName, categoryDescription);
    }
}