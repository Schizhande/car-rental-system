package com.vchizhande.webservice.dto;

import com.vchizhande.webservice.model.VehicleModel;
import lombok.Data;

@Data
public class VehicleModelDto {

    private Long id;

    private String manufacturer;

    private String modelName;

    public VehicleModel toVehicleModel() {
        return new VehicleModel(manufacturer, modelName);
    }
}