package com.vchizhande.webservice.controller;


import com.vchizhande.webservice.dto.RentalDto;
import com.vchizhande.webservice.model.Rental;
import com.vchizhande.webservice.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1/rentals")
public class RentalRestController {

    private final RentalService rentalService;

    public RentalRestController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping
    public Rental create(@RequestBody RentalDto rentalDto){
        return rentalService.create(rentalDto);
    }

    @PutMapping("/{id}")
    public  Rental update(@PathVariable Long id, @RequestBody RentalDto rentalDto){
        rentalDto.setId(id);
        return rentalService.update(rentalDto);
    }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable Long id){
        return rentalService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        rentalService.delete(id);
    }

    @GetMapping
    public Collection<Rental> getAllRentals(){
        return rentalService.findAllRentals();
    }


}
