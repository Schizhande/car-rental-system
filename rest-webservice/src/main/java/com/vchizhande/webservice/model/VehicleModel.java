package com.vchizhande.webservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vehicle_model")
public class VehicleModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String manufacturer;

    private String modelName;

    public VehicleModel() {
    }

    public VehicleModel(String manufacturer, String modelName) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
    }
}
