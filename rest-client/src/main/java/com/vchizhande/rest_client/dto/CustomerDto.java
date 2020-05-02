package com.vchizhande.rest_client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Data
public class CustomerDto {

    private Long id;

    @NotBlank(message = "is required")
    private String address;

    @NotBlank(message = "is required")
    private String customerNumber;

    @NotNull(message = "is required")
    @Past(message = "date should be in past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @NotBlank(message = "is required")
    @Email(message = "wrong email format")
    private String email;

    @NotBlank(message = "is required")
    private String phoneNumber;

    @NotBlank(message="is required")
    private String firstName;

    @NotBlank(message = "is required")
    private String gender;

    @NotBlank(message = "is required")
    private String lastName;

    @NotBlank(message = "is required")
    private String nationalId;

    private String nationalIdPhotoId;

    private String photoId;
}