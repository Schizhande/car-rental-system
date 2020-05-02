package com.vchizhande.rest_client.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class CustomerDto {

    private Long id;

    private String address;

    private String customerNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private String email;

    @NotBlank(message = "Phone number should be provided")
    private String phoneNumber;

    private String firstName;

    private String gender;

    private String lastName;

    private String nationalId;

    private String nationalIdPhotoId;

    private String photoId;
}