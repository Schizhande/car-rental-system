package com.vchizhande.rest_client.domain;

import lombok.Data;

@Data
public class Payments {

    private Long id;

    private double amount;

    private String currency;

    private Rental rental;

    private String paymentMethod;

    private String reference;

    private Customer customer;

}
