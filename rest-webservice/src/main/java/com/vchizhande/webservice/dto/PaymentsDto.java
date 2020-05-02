package com.vchizhande.webservice.dto;

import com.vchizhande.webservice.model.Payments;
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

    public Payments toPayments() {
        return new Payments(this.amount, currency, paymentMethod, reference);
    }
}