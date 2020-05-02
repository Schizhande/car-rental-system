package com.vchizhande.webservice.service;

import com.vchizhande.webservice.dto.VehicleDto;
import com.vchizhande.webservice.model.Vehicle;

import java.util.Collection;

public interface VehicleService {
    Vehicle findById(Long vehicleId);

    Vehicle create(VehicleDto vehicleDto);

    Vehicle update(VehicleDto vehicleDto);

    void delete(Long id);

    Collection<Vehicle> findAllVehicles();
}
