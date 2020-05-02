package com.vchizhande.webservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "payments")
public class Payments {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private double amount;

    private String currency;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    private String paymentMethod;

    private String reference;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Payments() {
    }

    public Payments(double amount, String currency, String paymentMethod, String reference) {
        this.amount = amount;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
        this.reference = reference;
    }
}
