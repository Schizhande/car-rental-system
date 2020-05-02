package com.vchizhande.webservice.service.impl;

import com.vchizhande.webservice.dto.VehicleDto;
import com.vchizhande.webservice.exception.RecordNotFoundException;
import com.vchizhande.webservice.model.Vehicle;
import com.vchizhande.webservice.model.VehicleCategory;
import com.vchizhande.webservice.model.VehicleModel;
import com.vchizhande.webservice.repository.VehicleRepository;
import com.vchizhande.webservice.service.VehicleCategoryService;
import com.vchizhande.webservice.service.VehicleModelService;
import com.vchizhande.webservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleCategoryService vehicleCategoryService;

    @Override
    public Vehicle findById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RecordNotFoundException("Vehicle with id " + vehicleId + " not found"));
    }

    @Override
    public Vehicle create(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleDto.toVehicle();
        VehicleCategory vehicleCategory = vehicleCategoryService.findById(vehicleDto.getCategoryId());
        VehicleModel vehicleModel = vehicleModelService.findById(vehicleDto.getModelId());
        vehicle.setVehicleCategory(vehicleCategory);
        vehicle.setVehicleModel(vehicleModel);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle update(VehicleDto vehicleDto) {
        Vehicle vehicle = findById(vehicleDto.getId());
        VehicleCategory vehicleCategory = vehicleCategoryService.findById(vehicleDto.getCategoryId());
        VehicleModel vehicleModel = vehicleModelService.findById(vehicleDto.getModelId());
        vehicle.setVehicleCategory(vehicleCategory);
        vehicle.setVehicleModel(vehicleModel);
        vehicle.setColor(vehicleDto.getColor());
        vehicle.setInitialMileage(vehicleDto.getInitialMileage());
        vehicle.setRegistrationNumber(vehicleDto.getRegistrationNumber());
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public Collection<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();
    }
}
