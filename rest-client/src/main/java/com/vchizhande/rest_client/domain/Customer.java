package com.vchizhande.rest_client.domain;


import lombok.Data;

import java.util.Date;

@Data
public class Customer {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    private Date dateOfBirth;

    private String address;

    private String nationalId;

    private String nationalIdPhotoId;

    private String photoId;

    private String customerNumber;
}
