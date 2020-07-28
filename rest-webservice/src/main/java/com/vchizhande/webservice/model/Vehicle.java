package com.vchizhande.webservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String initialMileage;

    private String name;

    private String registrationNumber;

    private String color;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private VehicleCategory vehicleCategory;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private VehicleModel vehicleModel;

    public Vehicle() {
    }

    public Vehicle(String initialMileage, String registrationNumber, String color) {
        this.initialMileage = initialMileage;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }
}
