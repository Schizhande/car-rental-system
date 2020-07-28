package com.vchizhande.rest_client.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class RentalDto {

    private Long id;

    @NotNull(message = "is required")
    private Long currentMileage;

//    @NotNull(message = "is required")
//    private Double penaltyFee;

    @NotNull(message = "is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rentDate;

    @NotNull(message = "is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rentEndDate;

    @NotNull(message = "is required")
    private Double rentFee;

//    @FutureOrPresent(message = "date should in future or present")
//    @NotNull(message = "is required")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date returnDate;

    @NotNull(message = "is required")
    private Long customerId;
//
//    @NotNull(message = "is required")
//    private Long userId;

    @NotNull(message = "is required")
    private Long vehicleId;

    private String status;

}