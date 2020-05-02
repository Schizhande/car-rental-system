package com.vchizhande.webservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vehicle_category")
public class VehicleCategory {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    private String categoryDescription;

    public VehicleCategory() {
    }

    public VehicleCategory(String categoryName, String categoryDescription) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }
}
