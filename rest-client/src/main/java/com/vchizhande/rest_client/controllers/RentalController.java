package com.vchizhande.rest_client.controllers;

import com.vchizhande.rest_client.configuration.BuildRestTemplate;
import com.vchizhande.rest_client.domain.Rental;
import com.vchizhande.rest_client.dto.CustomerDto;
import com.vchizhande.rest_client.dto.RentalDto;
import com.vchizhande.rest_client.dto.VehicleDto;
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
@RequestMapping("/car-rentals/")
public class RentalController {

    @GetMapping("list")
    public String gatCarRentals(Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        Rental[] rentals = restTemplate.getForObject("http://localhost:8081/v1/rentals", Rental[].class);
        model.addAttribute("rentals", rentals);
        return "list-rentals";
    }

    @GetMapping("add")
    public String addCarRentalForm(Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        VehicleDto[] vehicles = restTemplate.getForObject("http://localhost:8081/v1/vehicles", VehicleDto[].class);
        model.addAttribute("vehicles", vehicles);
        CustomerDto[] customers = restTemplate.getForObject("http://localhost:8081/v1/customers", CustomerDto[].class);
        model.addAttribute("customers", customers);
        model.addAttribute("rental", new RentalDto());
        return "save-rental";
    }

    @PostMapping("add")
    public String addCarRental(@Valid @ModelAttribute("rental") RentalDto rental, BindingResult result, Model model) {
        log.info("-------->Add rental");
        log.info("-----> has errors {}",result.hasErrors() );
        log.info("-----> errors {}", result.getModel());
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        if (result.hasErrors()) {
            VehicleDto[] vehicles = restTemplate.getForObject("http://localhost:8081/v1/vehicles", VehicleDto[].class);
            model.addAttribute("vehicles", vehicles);
            CustomerDto[] customers = restTemplate.getForObject("http://localhost:8081/v1/customers", CustomerDto[].class);
            model.addAttribute("customers", customers);
            return "save-rental";
        }
        restTemplate.postForObject("http://localhost:8081/v1/rentals",
                rental,
                RentalDto.class);
        return "redirect:/car-rentals/list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        RentalDto rentalDto = restTemplate.getForObject("http://localhost:8081/v1/rentals/{id}",
                RentalDto.class, id);
        model.addAttribute("rental", rentalDto);
        return "update-rental";
    }

    @GetMapping("view/{id}")
    public String view(@PathVariable long id, Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        Rental rentalDto = restTemplate.getForObject("http://localhost:8081/v1/rentals/{id}",
                Rental.class, id);
        model.addAttribute("rental", rentalDto);
        return "view-rental";
    }

    @PostMapping("update/{id}")
    public String updateCarRental(@PathVariable long id, @Valid @ModelAttribute("rental") RentalDto rental,
                                  BindingResult result) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        if (result.hasErrors()) {
            rental.setId(id);
            return "update-rental";
        }
        restTemplate.put("http://localhost:8081/v1/rentals/{id}",
                rental,
                rental.getId());
        return "redirect:/car-rentals/list";
    }

    @GetMapping("delete/{id}")
    public String deleteCarRental(@PathVariable("id") long id) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        restTemplate.delete("http://localhost:8081/v1/rentals/{id}",
                id);
        return "redirect:/car-rentals/list";
    }

}
