package com.vchizhande.webservice.controller;


import com.vchizhande.webservice.dto.PaymentsDto;
import com.vchizhande.webservice.model.Payments;
import com.vchizhande.webservice.service.PaymentsService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1/payments")
public class PaymentRestController {

    private final PaymentsService customerService;

    public PaymentRestController(PaymentsService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Payments create(@RequestBody PaymentsDto customerDto){
        return customerService.create(customerDto);
    }

    @PutMapping("/{id}")
    public  Payments update(@PathVariable Long id, @RequestBody PaymentsDto customerDto){
        customerDto.setId(id);
        return customerService.update(customerDto);
    }

    @GetMapping("/{id}")
    public Payments getPaymentsById(@PathVariable Long id){
        return customerService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        customerService.delete(id);
    }

    @GetMapping
    public Collection<Payments> getAllPayments(){
        return customerService.findAllPayments();
    }


}
