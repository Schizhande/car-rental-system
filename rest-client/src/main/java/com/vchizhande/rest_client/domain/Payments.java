package com.vchizhande.rest_client.domain;

import com.vchizhande.rest_client.dto.UserDetailsDto;
import lombok.Data;

import javax.persistence.*;

public class Payments {

    private Long id;

    private double amount;

    private String currency;

    private Rental rental;

    private String paymentMethod;

    private String reference;

    private Customer customer;

    private UserDetailsDto user;

}
