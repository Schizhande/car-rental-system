package com.vchizhande.webservice.controller;


import com.vchizhande.webservice.dto.VehicleDto;
import com.vchizhande.webservice.model.Vehicle;
import com.vchizhande.webservice.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1/vehicles")
public class VehicleRestController {

    private final VehicleService vehicleService;

    public VehicleRestController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public Vehicle create(@RequestBody VehicleDto vehicleDto){
        return vehicleService.create(vehicleDto);
    }

    @PutMapping("/{id}")
    public  Vehicle update(@PathVariable Long id, @RequestBody VehicleDto vehicleDto){
        vehicleDto.setId(id);
        return vehicleService.update(vehicleDto);
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id){
        return vehicleService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        vehicleService.delete(id);
    }

    @GetMapping
    public Collection<Vehicle> getAllVehicles(){
        return vehicleService.findAllVehicles();
    }


}
