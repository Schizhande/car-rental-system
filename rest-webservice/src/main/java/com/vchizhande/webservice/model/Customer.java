package com.vchizhande.webservice.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "en_ZW", timezone = "Africa/Harare")
    private Date dateOfBirth;

    private String address;

    private String phoneNumber;

    private String nationalId;

    private String nationalIdPhotoId;

    private String photoId;

    private String customerNumber;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, String gender, String phoneNumber, Date dateOfBirth, String address,
                    String nationalId, String customerNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.nationalId = nationalId;
        this.customerNumber = customerNumber;
        this.phoneNumber = phoneNumber;
    }
}
