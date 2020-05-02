package com.vchizhande.rest_client.controllers;

import com.vchizhande.rest_client.configuration.BuildRestTemplate;
import com.vchizhande.rest_client.domain.VehicleCategory;
import com.vchizhande.rest_client.dto.VehicleCategoryDto;
import com.vchizhande.rest_client.dto.VehicleModelDto;
import com.vchizhande.rest_client.dto.VehicleDto;
import com.vchizhande.rest_client.dto.VehicleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/vehicles/")
public class VehicleController {

    @GetMapping("list")
    public String gatVehicles(Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        VehicleDto[] vehicles = restTemplate.getForObject("http://localhost:8081/v1/vehicles", VehicleDto[].class);
        model.addAttribute("vehicles", vehicles);
        return "list-vehicles";
    }

    @GetMapping("add")
    public String addVehicleForm(Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        VehicleModelDto[] models = restTemplate.getForObject("http://localhost:8081/v1/vehicle-models", VehicleModelDto[].class);
        model.addAttribute("models", models);
        VehicleCategoryDto[] categories = restTemplate.getForObject("http://localhost:8081/v1/vehicle-categories", VehicleCategoryDto[].class);
        model.addAttribute("categories", categories);
        model.addAttribute("vehicle", new VehicleDto());
        return "save-vehicle";
    }

    @PostMapping("add")
    public String addVehicle(@Valid @ModelAttribute("vehicle")VehicleDto vehicle, BindingResult result, Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        if (result.hasErrors()) {
            VehicleCategoryDto[] categories = restTemplate.getForObject("http://localhost:8081/v1/vehicle-categories", VehicleCategoryDto[].class);
            model.addAttribute("categories", categories);
            VehicleModelDto[] models = restTemplate.getForObject("http://localhost:8081/v1/vehicle-models", VehicleModelDto[].class);
            model.addAttribute("models", models);
            return "save-vehicle";
        }
        restTemplate.postForObject("http://localhost:8081/v1/vehicles",
                vehicle,
                VehicleDto.class);
        return "redirect:/vehicles/list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        VehicleModelDto[] models = restTemplate.getForObject("http://localhost:8081/v1/vehicle-models", VehicleModelDto[].class);
        model.addAttribute("models", models);
        VehicleCategoryDto[] categories = restTemplate.getForObject("http://localhost:8081/v1/vehicle-categories", VehicleCategoryDto[].class);
        model.addAttribute("categories", categories);
        VehicleDto vehicleDto = restTemplate.getForObject("http://localhost:8081/v1/vehicles/{id}",
                VehicleDto.class, id);
        model.addAttribute("vehicle", vehicleDto);
        return "update-vehicle";
    }

    @PostMapping("update/{id}")
    public String updateVehicle(@PathVariable("id") long id, @Valid @ModelAttribute("vehicle") VehicleDto vehicle, BindingResult result, Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        if (result.hasErrors()) {
            vehicle.setId(id);
            VehicleCategoryDto[] categories = restTemplate.getForObject("http://localhost:8081/v1/vehicle-categories", VehicleCategoryDto[].class);
            model.addAttribute("categories", categories);
            VehicleModelDto[] models = restTemplate.getForObject("http://localhost:8081/v1/vehicle-models", VehicleModelDto[].class);
            model.addAttribute("models", models);
            return "update-vehicle";
        }
        restTemplate.put("http://localhost:8081/v1/vehicles/{id}",
                vehicle,
                vehicle.getId());
        return "redirect:/vehicles/list";
    }

    @GetMapping("delete/{id}")
    public String deleteVehicle(@PathVariable("id") long id) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        restTemplate.delete("http://localhost:8081/v1/vehicles/{id}",
                id);
        return "redirect:/vehicles/list";
    }

}
