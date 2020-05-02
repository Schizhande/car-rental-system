package com.vchizhande.webservice.service;

import com.vchizhande.webservice.dto.VehicleModelDto;
import com.vchizhande.webservice.model.VehicleModel;

import java.util.Collection;

public interface VehicleModelService {
    VehicleModel findById(Long modelId);

    VehicleModel update(VehicleModelDto vehicleModelDto);

    VehicleModel create(VehicleModelDto vehicleModelDto);

    void delete(Long id);

    Collection<VehicleModel> findAllVehicleModels();
}
