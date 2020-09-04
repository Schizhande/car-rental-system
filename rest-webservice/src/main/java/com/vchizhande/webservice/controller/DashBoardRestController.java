package com.vchizhande.webservice.controller;

import com.vchizhande.webservice.dto.DashBoardDTO;
import com.vchizhande.webservice.service.DashBoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/dashboard")
public class DashBoardRestController {

    private final DashBoardService dashBoardService;

    public DashBoardRestController(DashBoardService dashBoardService) {
        this.dashBoardService = dashBoardService;
    }

    @GetMapping("/cards")
    public DashBoardDTO getBashBoardCash() {
        return dashBoardService.getDashBoardCards();
    }
}
