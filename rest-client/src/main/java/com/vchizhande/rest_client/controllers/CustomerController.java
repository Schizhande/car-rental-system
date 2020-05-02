package com.vchizhande.rest_client.controllers;

import com.vchizhande.rest_client.configuration.BuildRestTemplate;
import com.vchizhande.rest_client.dto.RoleDto;
import com.vchizhande.rest_client.dto.CustomerDto;
import com.vchizhande.rest_client.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/customers/")
public class CustomerController {

    @GetMapping("list")
    public String gatCustomers(Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        CustomerDto[] customers = restTemplate.getForObject("http://localhost:8081/v1/customers", CustomerDto[].class);
        model.addAttribute("customers", customers);
        return "list-customers";
    }

    @GetMapping("add")
    public String addCustomerForm(Model model) {
        model.addAttribute("customer", new CustomerDto());
        return "save-customer";
    }

    @PostMapping("add")
    public String addCustomer(@Valid @ModelAttribute("customer") CustomerDto customer, BindingResult result) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        if (result.hasErrors()) {
            return "save-customer";
        }
        restTemplate.postForObject("http://localhost:8081/v1/customers",
                customer,
                CustomerDto.class);
        return "redirect:/customers/list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        CustomerDto customerDto = restTemplate.getForObject("http://localhost:8081/v1/customers/{id}",
                CustomerDto.class, id);
        model.addAttribute("customer", customerDto);
        return "update-customer";
    }

    @PostMapping("update/{id}")
    public String updateCustomer(@PathVariable long id, @Valid @ModelAttribute("customer") CustomerDto customer,
                                 BindingResult result) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        if (result.hasErrors()) {
            customer.setId(id);
            return "update-customer";
        }
        restTemplate.put("http://localhost:8081/v1/customers/{id}",
                customer,
                customer.getId());
        return "redirect:/customers/list";
    }

    @GetMapping("delete/{id}")
    public String deleteCustomer(@PathVariable("id") long id) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        restTemplate.delete("http://localhost:8081/v1/customers/{id}",
                id);
        return "redirect:/customers/list";
    }

}
