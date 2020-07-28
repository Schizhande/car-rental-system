package com.vchizhande.webservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "en_ZW", timezone = "Africa/Harare")
    private Date rentDate;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "en_ZW", timezone = "Africa/Harare")
    private Date rentEndDate;

    private double rentFee;

    private double penaltyFee;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "en_ZW", timezone = "Africa/Harare")
    private Date returnDate;

    private Long currentMileage;

    private String status;

    public Rental() {
    }

    public Rental(Date rentDate, Date rentEndDate, double rentFee, double penaltyFee, Date returnDate, Long currentMileage) {
        this.rentDate = rentDate;
        this.rentEndDate = rentEndDate;
        this.rentFee = rentFee;
        this.penaltyFee = penaltyFee;
        this.returnDate = returnDate;
        this.currentMileage = currentMileage;
        this.status = RentalStatus.OPENED.name();
    }
}
