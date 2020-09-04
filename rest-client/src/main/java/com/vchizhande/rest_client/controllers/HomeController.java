package com.vchizhande.rest_client.controllers;

import com.vchizhande.rest_client.configuration.BuildRestTemplate;
import com.vchizhande.rest_client.dto.CustomerDto;
import com.vchizhande.rest_client.dto.DashBoardDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        RestTemplate restTemplate = BuildRestTemplate.restTemplate();
        DashBoardDTO dashBoardDTOS = restTemplate.getForObject("http://localhost:8081/v1/dashboard/cards", DashBoardDTO.class);
        model.addAttribute("dashBoard", dashBoardDTOS);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }
}
