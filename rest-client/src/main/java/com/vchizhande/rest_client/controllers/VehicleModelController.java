package com.vchizhande.rest_client.controllers;

import com.vchizhande.rest_client.configuration.BuildRestTemplate;
import com.vchizhande.rest_client.dto.VehicleModelDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/vehicle-models/")
public class VehicleModelController {

    @GetMapping("list")
    public String gatVehicleModels(Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        VehicleModelDto[] vehicleCategories = restTemplate.getForObject("http://localhost:8081/v1/vehicle-models", VehicleModelDto[].class);
        model.addAttribute("vehicle-models", vehicleCategories);
        return "list-vehicle-models";
    }

    @GetMapping("add")
    public String addVehicleModelForm(Model model) {
        model.addAttribute("vehicleModel", new VehicleModelDto());
        return "save-vehicleModel";
    }

    @PostMapping("add")
    public String addVehicleModel(@Valid @ModelAttribute("vehicleModel") VehicleModelDto vehicleModel, BindingResult result) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        if (result.hasErrors()) {
            return "save-vehicleModel";
        }
        restTemplate.postForObject("http://localhost:8081/v1/vehicle-models",
                vehicleModel,
                VehicleModelDto.class);
        return "redirect:/vehicle-models/list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        VehicleModelDto vehicleModelDto = restTemplate.getForObject("http://localhost:8081/v1/vehicle-models/{id}",
                VehicleModelDto.class, id);
        model.addAttribute("vehicleModel", vehicleModelDto);
        return "update-vehicleModel";
    }

    @PostMapping("update/{id}")
    public String updateVehicleModel(@PathVariable long id, @Valid @ModelAttribute("vehicleModel") VehicleModelDto vehicleModel,
                                 BindingResult result) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        if (result.hasErrors()) {
            vehicleModel.setId(id);
            return "update-vehicleModel";
        }
        restTemplate.put("http://localhost:8081/v1/vehicle-models/{id}",
                vehicleModel,
                vehicleModel.getId());
        return "redirect:/vehicle-models/list";
    }

    @GetMapping("delete/{id}")
    public String deleteVehicleModel(@PathVariable long id) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        restTemplate.delete("http://localhost:8081/v1/vehicle-models/{id}",
                id);
        return "redirect:/vehicle-models/list";
    }

}
