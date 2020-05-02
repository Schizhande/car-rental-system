package com.vchizhande.rest_client.dto;

import lombok.Data;

@Data
public class PaymentsDto {

    private Long id;

    private double amount;

    private String currency;

    private String paymentMethod;

    private String reference;

    private Long customerId;

    private Long rentalId;

    private Long userId;

}