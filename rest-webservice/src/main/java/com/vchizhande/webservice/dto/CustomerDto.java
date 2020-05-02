package com.vchizhande.webservice.dto;

import com.vchizhande.webservice.model.Customer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Date;

@Data
public class CustomerDto {

    private Long id;

    private String address;

    private String customerNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private String email;

    private String firstName;

    private String phoneNumber;

    private String gender;

    private String lastName;

    private String nationalId;

    private String nationalIdPhotoId;

    private String photoId;

    public Customer toCustomer() {
        return new Customer(firstName, lastName, email, gender, phoneNumber, dateOfBirth, address, nationalId, customerNumber);
    }
}