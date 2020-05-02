package com.vchizhande.webservice.dto;

import com.vchizhande.webservice.model.Rental;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
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

    public Rental toRental() {
        return new Rental(rentDate, rentEndDate, rentFee, penaltyFee, returnDate, currentMileage);
    }
}