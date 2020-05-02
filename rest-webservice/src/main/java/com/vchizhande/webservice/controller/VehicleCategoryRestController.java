package com.vchizhande.webservice.controller;


import com.vchizhande.webservice.dto.VehicleCategoryDto;
import com.vchizhande.webservice.model.VehicleCategory;
import com.vchizhande.webservice.service.VehicleCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1/vehicle-categories")
public class VehicleCategoryRestController {

    private final VehicleCategoryService vehicleCategoryService;

    public VehicleCategoryRestController(VehicleCategoryService vehicleCategoryService) {
        this.vehicleCategoryService = vehicleCategoryService;
    }

    @PostMapping
    public VehicleCategory create(@RequestBody VehicleCategoryDto vehicleCategoryDto){
        return vehicleCategoryService.create(vehicleCategoryDto);
    }

    @PutMapping("/{id}")
    public  VehicleCategory update(@PathVariable Long id, @RequestBody VehicleCategoryDto vehicleCategoryDto){
        vehicleCategoryDto.setId(id);
        return vehicleCategoryService.update(vehicleCategoryDto);
    }

    @GetMapping("/{id}")
    public VehicleCategory getVehicleCategoryById(@PathVariable Long id){
        return vehicleCategoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        vehicleCategoryService.delete(id);
    }

    @GetMapping
    public Collection<VehicleCategory> getAllVehicleCategories(){
        return vehicleCategoryService.findAllVehicleCategories();
    }


}
