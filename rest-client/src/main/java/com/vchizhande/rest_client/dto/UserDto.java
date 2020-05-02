package com.vchizhande.rest_client.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Slf4j
@Data
public class UserDto {

    private Long id;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "password is required")
    private String password;

    @NotBlank(message = "full name is required")
    private String fullName;

    @NotBlank(message = "phone number is required")
    private String phoneNumber;

    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "is required")
    private String address;

    @NotNull(message = "is required")
    private Long roleId;
}
