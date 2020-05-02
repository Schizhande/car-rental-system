package com.vchizhande.webservice.dto;

import com.vchizhande.webservice.model.Vehicle;
import lombok.Data;

@Data
public class VehicleDto {

    private Long id;

    private String color;

    private String initialMileage;

    private String registrationNumber;

    private Long categoryId;

    private Long modelId;

    public Vehicle toVehicle() {
        return new Vehicle(initialMileage, registrationNumber, color);
    }
}