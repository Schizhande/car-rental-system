package com.vchizhande.rest_client.controllers;

import com.vchizhande.rest_client.configuration.BuildRestTemplate;
import com.vchizhande.rest_client.dto.VehicleCategoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/vehicle-categories/")
public class VehicleCategoryController {

    @GetMapping("list")
    public String gatVehicleCategorys(Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        VehicleCategoryDto[] vehicleCategories = restTemplate.getForObject("http://localhost:8081/v1/vehicle-categories", VehicleCategoryDto[].class);
        model.addAttribute("vehicle-categories", vehicleCategories);
        return "list-vehicle-categories";
    }

    @GetMapping("add")
    public String addVehicleCategoryForm(Model model) {
        model.addAttribute("vehicleCategory", new VehicleCategoryDto());
        return "save-vehicleCategory";
    }

    @PostMapping("add")
    public String addVehicleCategory(@Valid @ModelAttribute("vehicleCategory") VehicleCategoryDto vehicleCategory, BindingResult result) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        if (result.hasErrors()) {
            return "save-vehicleCategory";
        }
        restTemplate.postForObject("http://localhost:8081/v1/vehicle-categories",
                vehicleCategory,
                VehicleCategoryDto.class);
        return "redirect:/vehicle-categories/list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        VehicleCategoryDto vehicleCategoryDto = restTemplate.getForObject("http://localhost:8081/v1/vehicle-categories/{id}",
                VehicleCategoryDto.class, id);
        model.addAttribute("vehicleCategory", vehicleCategoryDto);
        return "update-vehicleCategory";
    }

    @PostMapping("update/{id}")
    public String updateVehicleCategory(@PathVariable long id, @Valid @ModelAttribute("vehicleCategory") VehicleCategoryDto vehicleCategory,
                                 BindingResult result) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        if (result.hasErrors()) {
            vehicleCategory.setId(id);
            return "update-vehicleCategory";
        }
        restTemplate.put("http://localhost:8081/v1/vehicle-categories/{id}",
                vehicleCategory,
                vehicleCategory.getId());
        return "redirect:/vehicle-categories/list";
    }

    @GetMapping("delete/{id}")
    public String deleteVehicleCategory(@PathVariable long id) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        restTemplate.delete("http://localhost:8081/v1/vehicle-categories/{id}",
                id);
        return "redirect:/vehicle-categories/list";
    }

}
