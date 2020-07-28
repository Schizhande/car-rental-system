package com.vchizhande.rest_client.domain;

import com.vchizhande.rest_client.dto.UserDetailsDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class Rental {

    private Long id;

    private Date rentDate;

    private Date rentEndDate;

    private double rentFee;

    private double penaltyFee;

    private Vehicle vehicle;

    private Customer customer;

    private UserDetailsDto user;

    private Date returnDate;

    private Long currentMileage;

    private String status;

}
