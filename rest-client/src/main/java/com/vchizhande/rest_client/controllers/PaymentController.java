package com.vchizhande.rest_client.controllers;

import com.vchizhande.rest_client.configuration.BuildRestTemplate;
import com.vchizhande.rest_client.domain.Payments;
import com.vchizhande.rest_client.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/payments/")
public class PaymentController {

    @GetMapping("list")
    public String gatPayments(Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        Payments[] payments = restTemplate.getForObject("http://localhost:8081/v1/payments", Payments[].class);

        model.addAttribute("payments", payments);
        return "list-payment";
    }

    @PostMapping("/add")
    public String addPayment(@Valid @ModelAttribute("payment") PaymentsDto payment, BindingResult result, Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        if (result.hasErrors()) {
            log.info("### errors " + result.getModel());
            return "save-payment";
        }
        restTemplate.postForObject("http://localhost:8081/v1/payments",
                payment,
                PaymentsDto.class);

        return "redirect:/car-rentals/list";
    }
}
