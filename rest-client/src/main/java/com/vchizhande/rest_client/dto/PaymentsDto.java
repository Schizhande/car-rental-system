package com.vchizhande.rest_client.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PaymentsDto {

    private Long id;

   @NotNull(message = "is required")
    private Double amount;

    @NotBlank(message = "is required")
    private String currency;

    @NotBlank(message = "is required")
    private String paymentMethod;

    @NotBlank(message = "is required")
    private String reference;

    @NotNull(message = "is required")
    private Long customerId;

    @NotNull(message = "is required")
    private Long rentalId;

    @NotNull(message = "is required")
    private Long userId;

}