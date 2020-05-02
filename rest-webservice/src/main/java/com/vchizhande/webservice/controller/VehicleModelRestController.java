package com.vchizhande.webservice.controller;


import com.vchizhande.webservice.dto.VehicleModelDto;
import com.vchizhande.webservice.model.VehicleModel;
import com.vchizhande.webservice.service.VehicleModelService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1/vehicle-models")
public class VehicleModelRestController {

    private final VehicleModelService vehicleModelService;

    public VehicleModelRestController(VehicleModelService vehicleModelService) {
        this.vehicleModelService = vehicleModelService;
    }

    @PostMapping
    public VehicleModel create(@RequestBody VehicleModelDto vehicleModelDto){
        return vehicleModelService.create(vehicleModelDto);
    }

    @PutMapping("/{id}")
    public  VehicleModel update(@PathVariable Long id, @RequestBody VehicleModelDto vehicleModelDto){
        vehicleModelDto.setId(id);
        return vehicleModelService.update(vehicleModelDto);
    }

    @GetMapping("/{id}")
    public VehicleModel getVehicleModelById(@PathVariable Long id){
        return vehicleModelService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        vehicleModelService.delete(id);
    }

    @GetMapping
    public Collection<VehicleModel> getAllVehicleModels(){
        return vehicleModelService.findAllVehicleModels();
    }


}
