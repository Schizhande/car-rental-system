package com.vchizhande.webservice.controller;


import com.vchizhande.webservice.dto.CustomerDto;
import com.vchizhande.webservice.model.Customer;
import com.vchizhande.webservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1/customers")
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer create(@RequestBody CustomerDto customerDto){
        return customerService.create(customerDto);
    }

    @PutMapping("/{id}")
    public  Customer update(@PathVariable Long id, @RequestBody CustomerDto customerDto){
        customerDto.setId(id);
        return customerService.update(customerDto);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        customerService.delete(id);
    }

    @GetMapping
    public Collection<Customer> getAllCustomers(){
        return customerService.findAllCustomers();
    }


}
