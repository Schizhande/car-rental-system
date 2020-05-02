package com.vchizhande.webservice.service;

import com.vchizhande.webservice.dto.VehicleCategoryDto;
import com.vchizhande.webservice.model.VehicleCategory;

import java.util.Collection;

public interface VehicleCategoryService {
    VehicleCategory findById(Long categoryId);

    VehicleCategory create(VehicleCategoryDto vehicleCategoryDto);

    VehicleCategory update(VehicleCategoryDto vehicleCategoryDto);

    void delete(Long id);

    Collection<VehicleCategory> findAllVehicleCategories();
}
