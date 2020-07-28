package com.vchizhande.rest_client.domain;

import lombok.Data;

@Data
public class Vehicle {

    private Long id;

    private String name;

    private String initialMileage;

    private String registrationNumber;

    private String color;

    private VehicleCategory vehicleCategory;

    private VehicleModel vehicleModel;

}
