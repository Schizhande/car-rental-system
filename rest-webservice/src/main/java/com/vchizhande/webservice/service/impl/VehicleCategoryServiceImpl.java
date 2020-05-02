package com.vchizhande.webservice.service.impl;

import com.vchizhande.webservice.dto.VehicleCategoryDto;
import com.vchizhande.webservice.exception.RecordNotFoundException;
import com.vchizhande.webservice.model.VehicleCategory;
import com.vchizhande.webservice.repository.VehicleCategoryRepository;
import com.vchizhande.webservice.service.VehicleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VehicleCategoryServiceImpl implements VehicleCategoryService {

    @Autowired
    private VehicleCategoryRepository vehicleCategoryRepository;

    @Override
    public VehicleCategory findById(Long categoryId) {
        return vehicleCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RecordNotFoundException("Vehicle with id " + categoryId + " not found"));
    }

    @Override
    public VehicleCategory create(VehicleCategoryDto vehicleCategoryDto) {

        VehicleCategory vehicleCategory = vehicleCategoryDto.toVehicleCategory();
        return vehicleCategoryRepository.save(vehicleCategory);
    }

    @Override
    public VehicleCategory update(VehicleCategoryDto vehicleCategoryDto) {
        VehicleCategory vehicleCategory = findById(vehicleCategoryDto.getId());
        vehicleCategory.setCategoryName(vehicleCategoryDto.getCategoryName());
        vehicleCategory.setCategoryDescription(vehicleCategoryDto.getCategoryDescription());
        return vehicleCategoryRepository.save(vehicleCategory);
    }

    @Override
    public void delete(Long id) {
        vehicleCategoryRepository.deleteById(id);
    }

    @Override
    public Collection<VehicleCategory> findAllVehicleCategories() {
        return vehicleCategoryRepository.findAll();
    }
}
