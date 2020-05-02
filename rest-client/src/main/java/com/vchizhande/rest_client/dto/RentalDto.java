package com.vchizhande.rest_client.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RentalDto {

    private Long id;

    private Integer currentMileage;

    private double penaltyFee;

    private Date rentDate;

    private Date rentEndDate;

    private double rentFee;

    private Date returnDate;

    private Long customerId;

    private Long userId;

    private Long vehicleId;

}