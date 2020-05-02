package com.vchizhande.webservice.service.impl;

import com.vchizhande.webservice.dto.VehicleModelDto;
import com.vchizhande.webservice.exception.RecordNotFoundException;
import com.vchizhande.webservice.model.VehicleModel;
import com.vchizhande.webservice.repository.VehicleModelRepository;
import com.vchizhande.webservice.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VehicleModelServiceImpl implements VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Override
    public VehicleModel findById(Long modelId) {
        return vehicleModelRepository.findById(modelId)
                .orElseThrow(() -> new RecordNotFoundException("Vehicle model with id " + modelId + " not found"));
    }

    @Override
    public VehicleModel create(VehicleModelDto vehicleModelDto) {
        VehicleModel vehicleModel = vehicleModelDto.toVehicleModel();
        return vehicleModelRepository.save(vehicleModel);
    }

    @Override
    public VehicleModel update(VehicleModelDto vehicleModelDto) {
        VehicleModel vehicleModel = findById(vehicleModelDto.getId());
        vehicleModel.setManufacturer(vehicleModelDto.getManufacturer());
        vehicleModel.setModelName(vehicleModelDto.getModelName());
        return vehicleModelRepository.save(vehicleModel);
    }

    @Override
    public void delete(Long id) {
        vehicleModelRepository.deleteById(id);
    }

    @Override
    public Collection<VehicleModel> findAllVehicleModels() {
        return vehicleModelRepository.findAll();
    }
}
